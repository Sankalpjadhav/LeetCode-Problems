class Solution {
    private int maxNumOfAchievableRequests = (int)-1e9;
    public int maximumRequests(int n, int[][] requests) {
        int [] count = new int[n];
        
        helper(0, requests, n, count, 0);
        
        return maxNumOfAchievableRequests;
    }
    
    private void helper(int index, int [][] requests, int n, int [] count, int numberOfRequestsGranted){
        if(index == requests.length){
            for(int num: count){
                if(num != 0){
                    return;
                }
            }
            maxNumOfAchievableRequests = Math.max(maxNumOfAchievableRequests, numberOfRequestsGranted);
            return;
        }
        
        
        // Pick
        count[requests[index][0]]++;
        count[requests[index][1]]--;
        
        helper(index+1, requests, n, count, numberOfRequestsGranted+1);
        
        count[requests[index][0]]--;
        count[requests[index][1]]++;
        
        // Not Pick
        helper(index+1, requests, n, count, numberOfRequestsGranted);
    }
}
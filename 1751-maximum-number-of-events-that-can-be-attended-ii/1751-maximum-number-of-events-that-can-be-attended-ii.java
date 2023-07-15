class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a,b)-> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0] );
        HashMap<String, Integer> memo = new HashMap<>();
        return helper(0, n, -1, events, k, memo);
    }
    
    private int helper(int index, int n, int previousEndDate, int [][] events, int k, HashMap<String, Integer> memo){
        if(index == n || k == 0){
            return 0;
        }
        String str = index +"-"+ previousEndDate +"-"+ k; 
        if(memo.containsKey(str)){
            return memo.get(str);
        }
        
        int pick = 0;
        if(previousEndDate == -1 || events[index][0] > previousEndDate){
            pick = events[index][2] + helper(index+1, n, events[index][1], events, k-1, memo);
        }
        
        int notPick = 0 + helper(index+1, n, previousEndDate, events, k, memo);
        int result = Math.max(notPick, pick);
        memo.put(str, result);
        return result;
    }
}
class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        
        int n = nums.length;
        HashMap<Integer, int[]> freqMap = new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(!freqMap.containsKey(nums[i])){
                int [] detail = {1, i, i}; // (count, leftBoundary, rightBoundary)
                freqMap.put(nums[i], detail);
            }
            else{
                int [] detail = freqMap.get(nums[i]);
                detail[0]++;
                detail[2] = i;
                freqMap.put(nums[i], detail);
            }
        }
        
        
        int degree = -1;
        int subArrayLength = Integer.MAX_VALUE;
        
        for(int [] detail: freqMap.values()){
            if (detail[0] > degree){
                degree = detail[0];
                subArrayLength = detail[2] - detail[1] + 1;
            } else if (detail[0] == degree){
                subArrayLength = Math.min( detail[2] - detail[1] + 1, subArrayLength);
            } 
        }
        
        return subArrayLength;
    }
}
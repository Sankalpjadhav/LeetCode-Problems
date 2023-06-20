class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k == 0){
            return nums;
        }
        int n = nums.length;
        long [] prefixSum = new long[n];
        int diameter = 2*k + 1;
        
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        
        
        int [] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int i=k;i<n-k;i++){
            long temp = (prefixSum[i+k] - prefixSum[i-k] + nums[i-k])/diameter;
            result[i] = (int) temp;
        }
        
        return result;
    }
}
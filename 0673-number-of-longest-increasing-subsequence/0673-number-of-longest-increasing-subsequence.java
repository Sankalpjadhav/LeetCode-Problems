class Solution {
    
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        int [] count = new int[n];
        int maxi = 1;
        for(int ind=0;ind<n;ind++){
            dp[ind] = 1;
            count[ind] = 1;
            for(int prev_ind=0;prev_ind<ind;prev_ind++){
                if(nums[prev_ind] < nums[ind] && 1+dp[prev_ind] > dp[ind]){
                    dp[ind] = 1 + dp[prev_ind];
                    count[ind] = count[prev_ind];
                }
                else if(nums[prev_ind] < nums[ind] && 1+dp[prev_ind]==dp[ind]){
                    count[ind] += count[prev_ind];
                }
            }
            maxi = Math.max(maxi, dp[ind]);
        }
        int noOfLIS = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxi){
                noOfLIS += count[i];
            }
        }
        
        return noOfLIS;
    }
    
    
}
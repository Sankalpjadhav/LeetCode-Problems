class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for(int i : nums)
            sum += i;
        
        sum = sum - target;
        
        if(sum < 0 || sum % 2 == 1) return 0;
        
        sum /= 2;
        
        int[][] dp = new int[nums.length + 1][sum + 1];
       
        for(int i=0; i <= nums.length; i++){
            
            dp[i][0] = 1;
            
        }
        
        subsetCount(nums, sum, nums.length, dp);
        
        return dp[nums.length][sum];
    }
    
    public void subsetCount(int[] nums, int sum, int n, int[][] dp){
        
        for(int i = 1; i <= n ; i++){
            
            for(int j = 0; j <= sum ; j++){
                
                if(nums[i-1] <= j)
                dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                else
                   dp[i][j] =  dp[i-1][j];
                
            }   
        }  
    }
    


}
class Solution {
   public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        
        if(sum%2 != 0){
            return false;
        }
        
        return subsetSum(nums, sum/2, nums.length);
    }
    
    public boolean subsetSum(int [] nums, int sum, int n){
        boolean [][] dp = new boolean[n+1][sum+1];
        // initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    dp[i][j] = false;
                }
                if(j==0){
                    dp[i][j] = true;
                }
            }
        }
        // Main code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
        
    }
}

/*
RECURSION:

public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num: nums){
            sum+=num;
        }

        if(sum % 2 != 0) return false;

        return helper(0, sum/2, n, nums);
    }

    private boolean helper(int index, int sum, int n, int [] nums){
        if(sum == 0){
            return true;
        }
        if(index == n){
            return false;
        }

        boolean notPick = helper(index+1, sum, n, nums);
        boolean pick = helper(index+1, sum - nums[index], n, nums);

        return notPick || pick;
    }
*/
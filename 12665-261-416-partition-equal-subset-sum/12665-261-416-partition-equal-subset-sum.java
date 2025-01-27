class Solution {
   public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        
        if(sum%2 != 0){
            return false;
        }

        sum = sum/2;

        int n = nums.length;
        
       boolean [][] dp = new boolean[n+1][sum+1];

       for(int i=0;i<n+1;i++){
            dp[i][0] = true;
       }

        // By default it will be false
       for(int j=0;j<dp[0].length;j++){
            dp[n][j] = false;
       }

       for(int index=n-1;index>=0;index--){
            for(int s=1;s<=sum;s++){
                boolean notPick = dp[index+1][s];
                boolean pick = false;
                if(s-nums[index] >= 0) pick = dp[index+1][s - nums[index]];

                dp[index][s] = notPick || pick;
            }
       }

       return dp[0][sum];
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
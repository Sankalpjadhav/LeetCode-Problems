class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        int maxi = -1;
        Arrays.fill(dp, 1);

        for(int index=1;index<n;index++){
            for(int prevIndex=0;prevIndex<index;prevIndex++){
                if(nums[prevIndex] < nums[index] && dp[index] < dp[prevIndex]+1){
                    dp[index] = dp[prevIndex] + 1;
                    maxi = Math.max(maxi, dp[index]);
                }
            }
        }

        return maxi == -1 ? 1 : maxi;
            
    }
}

/*
DP:

public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int index=n-1;index>=0;index--){
            for(int prevIndex=index-1;prevIndex>=-1;prevIndex--){
                int notTake = 0 + dp[index+1][prevIndex+1];
                int take = 0;
                if(prevIndex == -1 || nums[prevIndex] < nums[index]){
                    take = 1 + dp[index+1][index+1];
                }

                dp[index][prevIndex+1] = Math.max(notTake, take);
            }
        } 

        return dp[0][-1+1];
            
    }

Memoization: TC: O(n*n), SC: O(n) + O(n*n)

public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][] memo = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return findLIS(0, -1, n, nums, memo);
    }

    private int findLIS(int index, int prevIndex, int n, int [] nums, int [][] memo){
        if(index == n){
            return 0;
        }

        if(memo[index][prevIndex+1] != -1){
            return memo[index][prevIndex+1];
        }

        int notTake = 0 + findLIS(index+1, prevIndex, n, nums, memo);
        int take = 0;
        if(prevIndex == -1 || nums[prevIndex] < nums[index]){
            take = 1 + findLIS(index+1, index, n, nums, memo);
        }

        return memo[index][prevIndex+1] = Math.max(notTake, take);
    }

Recursion: TC: Exponential, SC: O(n)

public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        return findLIS(0, -1, n, nums);
    }

    private int findLIS(int index, int prevIndex, int n, int [] nums){
        if(index == n){
            return 0;
        }

        int notTake = 0 + findLIS(index+1, prevIndex, n, nums);
        int take = 0;
        if(prevIndex == -1 || nums[prevIndex] < nums[index]){
            take = 1 + findLIS(index+1, index, n, nums);
        }

        return Math.max(notTake, take);
    }
*/
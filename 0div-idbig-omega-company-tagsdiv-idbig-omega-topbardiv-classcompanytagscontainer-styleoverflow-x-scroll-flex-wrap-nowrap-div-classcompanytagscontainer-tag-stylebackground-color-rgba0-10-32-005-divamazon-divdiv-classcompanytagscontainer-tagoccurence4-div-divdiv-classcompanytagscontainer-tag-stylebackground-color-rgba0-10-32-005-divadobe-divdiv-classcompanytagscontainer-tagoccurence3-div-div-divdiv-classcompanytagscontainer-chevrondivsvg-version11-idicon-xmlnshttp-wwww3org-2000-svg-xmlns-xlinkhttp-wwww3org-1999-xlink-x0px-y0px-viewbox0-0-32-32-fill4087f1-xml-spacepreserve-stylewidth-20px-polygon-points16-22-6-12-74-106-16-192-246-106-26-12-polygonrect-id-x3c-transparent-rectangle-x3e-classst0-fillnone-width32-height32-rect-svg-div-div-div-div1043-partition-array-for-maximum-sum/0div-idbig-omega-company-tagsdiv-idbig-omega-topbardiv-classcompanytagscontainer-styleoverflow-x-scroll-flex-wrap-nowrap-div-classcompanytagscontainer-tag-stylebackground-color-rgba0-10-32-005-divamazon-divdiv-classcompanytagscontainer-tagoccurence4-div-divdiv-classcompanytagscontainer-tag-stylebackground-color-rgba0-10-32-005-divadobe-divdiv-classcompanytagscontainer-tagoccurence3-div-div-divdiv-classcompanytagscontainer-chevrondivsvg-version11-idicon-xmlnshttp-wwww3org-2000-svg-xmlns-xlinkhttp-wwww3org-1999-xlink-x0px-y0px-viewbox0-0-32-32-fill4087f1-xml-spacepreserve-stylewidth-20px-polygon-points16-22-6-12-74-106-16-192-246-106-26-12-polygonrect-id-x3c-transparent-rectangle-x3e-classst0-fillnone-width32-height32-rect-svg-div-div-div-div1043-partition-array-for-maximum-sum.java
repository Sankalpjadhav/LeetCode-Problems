class Solution {
    public int maxSumAfterPartitioning(int[] nums, int k) {
        int n = nums.length;
        int [] dp = new int[n+1];
        dp[n] = 0;

        for(int index=n-1;index>=0;index--){
            int maxSum = 0;
            int len = 0;
            int maxi = 0;

            for(int i=index;i<Math.min(n, index+k);i++){
                len++;
                maxi = Math.max(maxi, nums[i]);
                maxSum = Math.max(maxSum, (len * maxi) + dp[i+1]); 
            }

            dp[index] = maxSum;
        }


        return dp[0];
    }

}

/*

MEMOIZATION: 

    public int maxSumAfterPartitioning(int[] nums, int k) {
        int n = nums.length;
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(0, nums, k, n, memo);
    }

    private int helper(int index, int [] nums, int k, int n, int [] memo){
        if(index == n){
            return 0;
        }

        if(memo[index]!=-1){
            return memo[index];
        }

        int maxSum = 0;
        int len = 0;
        int maxi = 0;

        for(int i=index;i<Math.min(n, index+k);i++){
            len++;
            maxi = Math.max(maxi, nums[i]);
            maxSum = Math.max(maxSum, (len * maxi) + helper(i+1, nums, k, n, memo)); 
        }

        return memo[index] = maxSum;
    }

RECURSION: Obviously gives TLE 

    public int maxSumAfterPartitioning(int[] nums, int k) {
        int n = nums.length;
        return helper(0, nums, k, n);
    }

    private int helper(int index, int [] nums, int k, int n){
        if(index == n){
            return 0;
        }

        int maxSum = 0;
        int len = 0;
        int maxi = 0;

        for(int i=index;i<Math.min(n, index+k);i++){
            len++;
            maxi = Math.max(maxi, nums[i]);
            maxSum = Math.max(maxSum, (len * maxi) + helper(i+1, nums, k, n)); 
        }

        return maxSum;
    }

*/
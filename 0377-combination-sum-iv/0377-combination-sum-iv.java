class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int [] dp = new int[target+1];
        dp[0] = 1;

        for(int tar=1;tar<=target;tar++){
            int count = 0;
            for(int i=0;i<n;i++){
                if(tar - nums[i] >= 0){
                    count += dp[tar - nums[i]];
                }
            }
            dp[tar] = count;
        }
        return dp[target];
    }
}


/*

Memoization: Beats 100% java submissions 
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int [] memo = new int[target+1];
        Arrays.fill(memo, -1);
        return helper(n, target, nums, memo);
    }

    private int helper(int n, int target, int [] nums, int [] memo){
        if(target == 0){
            return 1;
        }

        if(memo[target]!=-1){
            return memo[target];
        }

        int count = 0;
        for(int i=0;i<n;i++){
            if(target - nums[i] >= 0){
                count += helper(n, target - nums[i], nums, memo);
            }
        }

        return memo[target] = count;
    }



Recursion: Gives TLE (10 / 15 testcases passed)
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;

        return helper(n, target, nums);
    }

    private int helper(int n, int target, int [] nums){
        if(target == 0){
            return 1;
        }

        int count = 0;
        for(int i=0;i<n;i++){
            if(target - nums[i] >= 0){
                count += helper(n, target - nums[i], nums);
            }
        }

        return count;
    }

*/
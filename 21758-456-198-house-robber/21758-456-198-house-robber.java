class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int next2 = nums[n-1];
        int next = Math.max(nums[n-2], nums[n-1]);

        for(int i=n-3;i>=0;i--){
            int notRobCurrentHouse = 0 + next;
            int robCurrentHouse = nums[i] + next2;
            int current = Math.max(notRobCurrentHouse, robCurrentHouse);
            next2 = next;
            next = current;
        }

        return next;
    }

}

/*
Tabulation: TC: O(n), SC: O(n)

public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int [] dp = new int [n];
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-2], nums[n-1]);

        for(int i=n-3;i>=0;i--){
            int notRobCurrentHouse = 0 + dp[i+1];
            int robCurrentHouse = nums[i] + dp[i+2];
            dp[i] = Math.max(notRobCurrentHouse, robCurrentHouse);
        }

        return dp[0];
    }

Memoization: Time complexity: O(n), Space complexity: O(n) + O(n) for recursion stack space and memo array.
public int rob(int[] nums) {
        int n = nums.length;
        int [] memo = new int [n];
        Arrays.fill(memo, -1);
        return letsRob(0, n, memo, nums);
    }

    private int letsRob(int index, int n, int [] memo, int [] nums){
        if(index == n-1){
            return nums[index];
        }

        if(index >= n){
            return 0;
        }

        if(memo[index]!=-1) return memo[index];

        int notRobCurrentHouse = 0 + letsRob(index+1, n, memo, nums);
        int robCurrentHouse = nums[index] + letsRob(index+2, n, memo, nums);

        return memo[index] = Math.max(notRobCurrentHouse, robCurrentHouse);
    }

Recursion: Time complexity: O(2^n), Space complexity: O(n) for recursion stack space.

public int rob(int[] nums) {
        int n = nums.length;
        return letsRob(0, n, nums);
    }

    private int letsRob(int index, int n, int [] nums){
        if(index == n-1){
            return nums[index];
        }

        if(index >= n){
            return 0;
        }

        int notRobCurrentHouse = 0 + letsRob(index+1, n, nums);
        int robCurrentHouse = nums[index] + letsRob(index+2, n, nums);

        return Math.max(notRobCurrentHouse, robCurrentHouse);
    }
*/
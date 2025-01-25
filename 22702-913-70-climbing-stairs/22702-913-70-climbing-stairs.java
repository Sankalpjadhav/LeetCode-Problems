class Solution {
    // Optimized tabulation: Time complexity: O(n), Space complexity: O(1)
    public int climbStairs(int n) {
        int next2 = 1;
        int next1 = 1;
        for(int i=n-2;i>=0;i--){
            int current = next1 + next2;
            next2 = next1;
            next1 = current;
        }
        return next1;
    }
}

/*
Tabulation: Time complexity: O(n), Space complexity: O(n)

    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            dp[i] = dp[i+1];
            if(i + 2 <= n){
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }


Memoization: Time complexity: O(n), Space complexity: O(n) + O(n) for recursion stack space and memo.
    public int climbStairs(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return helper(0, n, memo);
    }

    private int helper(int index, int n, int [] memo){
        if(index == n){
            return 1;
        }

        if(index > n){
            return 0;
        }

        if(memo[index]!=-1){
            return memo[index];
        }

        return memo[index] = helper(index+1, n, memo) + helper(index+2, n, memo);
    }

Recursion: Time complexity: O(2^n), Space complexity: O(n) i.e. recursion stack space.

public int climbStairs(int n) {
        return helper(0, n);
    }

    private int helper(int index, int n){
        if(index == n){
            return 1;
        }

        if(index > n){
            return 0;
        }

        return helper(index+1, n) + helper(index+2, n);
    }
*/
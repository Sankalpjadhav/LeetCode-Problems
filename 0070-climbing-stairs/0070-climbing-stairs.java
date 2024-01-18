class Solution {
    public int climbStairs(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return helper(0, n, memo);
    }

    private int helper(int ind, int n, int [] memo){
        if(ind == n){
            return 1;
        }

        if(ind > n){
            return 0;
        }

        if(memo[ind] != -1){
            return memo[ind];
        }

        return memo[ind] = helper(ind+1, n, memo) + helper(ind+2, n, memo);
    }
}


/**
Recursion:
    public int climbStairs(int n) {
        return helper(0, n);
    }

    private int helper(int ind, int n){
        if(ind == n){
            return 1;
        }

        if(ind > n){
            return 0;
        }

        return helper(ind+1, n) + helper(ind+2, n);
    }

Memoization:
 */
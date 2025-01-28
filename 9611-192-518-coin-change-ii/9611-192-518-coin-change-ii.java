class Solution {
        
    public int change(int amount, int[] coins) {
        // DP
        int n = coins.length;
        int [][] dp = new int[n+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0){
                    dp[i][j] = 0;
                }
                if(j==0){
                    dp[i][j] = 1;
                }
            }
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
        /*
        Memoization
        int [][] memo = new int[n+1][amount+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i], -1);
        }
        return combinationsOfCoins(n, amount, coins, memo);
        */
    
    }
    /*
    public int combinationsOfCoins(int n, int amount, int [] coins, int[][] memo){
        if(amount==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(memo[n][amount]!=-1){
            return memo[n][amount];
        }
        if(coins[n-1]<=amount){
            return memo[n][amount] = combinationsOfCoins(n, amount - coins[n-1], coins, memo) + combinationsOfCoins(n-1, amount, coins, memo);
        }
        return memo[n][amount] = combinationsOfCoins(n-1, amount, coins, memo);
    }
    */
}
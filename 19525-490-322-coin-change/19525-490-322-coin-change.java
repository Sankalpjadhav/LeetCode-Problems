class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n+1][amount+1];
        
        
        for(int amt=1;amt<=amount;amt++){
            dp[0][amt] = (int)1e9;
        }
        
        for(int index=1;index<n+1;index++){
            for(int amt=1;amt<=amount;amt++){
                int notTake = 0 + dp[index-1][amt];
                int take = (int)1e9;
                if(coins[index-1] <= amt){
                    take = 1 + dp[index][amt-coins[index-1]];
                }

                dp[index][amt] = Math.min(notTake, take);
            }
        }
        
        
        int result = dp[n][amount];
        
        if(result == (int)1e9){
            return -1;
        }
        
        return result;
    }
}


/*
Recursion: Gives TLE

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int result = helper(n-1, coins, amount);
        if(result == (int)1e9){
            return -1;
        }
        
        return result;
    }
    
    private int helper(int index, int [] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(index < 0){
            return (int)1e9;
        }
        
        int notTake = 0 + helper(index-1, coins, amount);
        int take = (int)1e9;
        if(coins[index] <= amount){
            take = 1 + helper(index, coins, amount-coins[index]);
        }
        
        return Math.min(notTake, take);
    }
    
Memoization:

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] memo = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        int result = helper(n-1, coins, amount, memo);
        
        if(result == (int)1e9){
            return -1;
        }
        
        return result;
    }
    
    private int helper(int index, int [] coins, int amount, int [][] memo){
        if(amount == 0){
            return 0;
        }
        if(index < 0){
            return (int)1e9;
        }
        
        if(memo[index][amount]!=-1){
            return memo[index][amount];
        }
        
        int notTake = 0 + helper(index-1, coins, amount, memo);
        int take = (int)1e9;
        if(coins[index] <= amount){
            take = 1 + helper(index, coins, amount-coins[index], memo);
        }
        
        return memo[index][amount] = Math.min(notTake, take);
    }
*/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n+1][2][3];
        for(int index=n-1;index>=0;index--){
            for(int buy=1;buy>=0;buy--){
                for(int transactions=2;transactions>0;transactions--){
                    if(buy == 0){
                        // We are allowed to buy
                        int letsBuy = -prices[index] + dp[index+1][1][transactions];
                        int skipBuy = dp[index+1][0][transactions];
                        dp[index][buy][transactions] = Math.max(letsBuy, skipBuy);
                    }
                    else{
                        // We need to sell
                        int letsSell = +prices[index] + dp[index+1][0][transactions-1];
                        int skipSell = dp[index+1][1][transactions];

                        dp[index][buy][transactions] = Math.max(letsSell, skipSell);
                    }
                }
            }
        }
        return dp[0][0][2];
    }

}

/*
Memoization:

public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] memo = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        return helper(0, 0, 2, n, prices, memo);
    }

    private int helper(int index, int buy, int transactions, int n, int [] prices, int [][][] memo){
        if(transactions == 0){
            return 0;
        }

        if(index == n){
            return 0;
        }

        if(memo[index][buy][transactions] != -1){
            return memo[index][buy][transactions];
        }

        if(buy == 0){
            // We are allowed to buy
            int letsBuy = -prices[index] + helper(index+1, 1, transactions, n, prices, memo);
            int skipBuy = helper(index+1, 0, transactions, n, prices, memo);
            return memo[index][buy][transactions] = Math.max(letsBuy, skipBuy);
        }

        // We need to sell
        int letsSell = +prices[index] + helper(index+1, 0, transactions-1, n, prices, memo);
        int skipSell = helper(index+1, 1, transactions, n, prices, memo);

        return memo[index][buy][transactions] = Math.max(letsSell, skipSell);
    }

Recursion:

public int maxProfit(int[] prices) {
        int n = prices.length;

        return helper(0, 0, 2, n, prices);
    }

    private int helper(int index, int buy, int transactions, int n, int [] prices){
        if(transactions == 0){
            return 0;
        }

        if(index == n){
            return 0;
        }

        if(buy == 0){
            // We are allowed to buy
            int letsBuy = -prices[index] + helper(index+1, 1, transactions, n, prices);
            int skipBuy = helper(index+1, 0, transactions, n, prices);
            return Math.max(letsBuy, skipBuy);
        }

        // We need to sell
        int letsSell = +prices[index] + helper(index+1, 0, transactions-1, n, prices);
        int skipSell = helper(index+1, 1, transactions, n, prices);

        return Math.max(letsSell, skipSell);
    }
*/
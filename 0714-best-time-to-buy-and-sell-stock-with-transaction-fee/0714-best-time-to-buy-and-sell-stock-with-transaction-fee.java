class Solution {
    // 2 1D space optimised
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int [] next = new int[2];
        int [] curr = new int[2];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if(buy == 1){
                    curr[buy] = Math.max(-prices[ind] + next[0], 0 + next[1]);
                }
                else{
                    curr[buy] = Math.max(prices[ind] - fee + next[1], 0 + next[0]);
                }
            }
            next = curr;
        }
        return next[1];
    }
}

/*
Recursion:
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        return calcMaxProfit(0, 1, prices, n, fee);
    }
    
    private int calcMaxProfit(int ind, int buy, int [] prices, int n, int fee){
        if(ind == n) return 0;
        
        if(buy == 1){
            return Math.max(-prices[ind] + calcMaxProfit(ind+1, 0, prices, n, fee), 0 + calcMaxProfit(ind+1, 1, prices, n, fee));
        }
        else{
            return Math.max(prices[ind] - fee + calcMaxProfit(ind+1, 1, prices, n, fee), 0 + calcMaxProfit(ind+1, 0, prices, n, fee));
        }
    }
    
Memoization:
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int [][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return calcMaxProfit(0, 1, prices, n, fee, dp);
    }
    
    private int calcMaxProfit(int ind, int buy, int [] prices, int n, int fee, int [][] dp){
        if(ind == n) return 0;
        
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        
        if(buy == 1){
            return dp[ind][buy] = Math.max(-prices[ind] + calcMaxProfit(ind+1, 0, prices, n, fee, dp), 0 + calcMaxProfit(ind+1, 1, prices, n, fee, dp));
        }
        else{
            return dp[ind][buy] = Math.max(prices[ind] - fee + calcMaxProfit(ind+1, 1, prices, n, fee, dp), 0 + calcMaxProfit(ind+1, 0, prices, n, fee, dp));
        }
    }
    
Tabulation:
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int [][] dp = new int[n+1][2];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if(buy == 1){
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);
                }
                else{
                    dp[ind][buy] = Math.max(prices[ind] - fee + dp[ind+1][1], 0 + dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];
    }
*/
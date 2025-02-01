class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        /*
            1 Means Buy
            0 Means Sell
        */
        
        int [][] memo = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return calculateProfit(0, 1, prices, fee, memo);
    }
    
    private int calculateProfit(int index, int buy, int [] prices, int fee, int [][] memo){
        if(index == prices.length){
            return 0;
        }
        
        if(memo[index][buy] != -1){
            return memo[index][buy];
        }
        
        if(buy == 1){
            return memo[index][buy] = Math.max( -prices[index] + calculateProfit(index+1, 0, prices, fee, memo), 0 + calculateProfit(index+1, 1, prices, fee, memo));    
        }
        else{
            return memo[index][buy] = Math.max( prices[index] - fee + calculateProfit(index+1, 1, prices, fee, memo), 0 + calculateProfit(index+1, 0, prices, fee, memo));
        }
    }
}
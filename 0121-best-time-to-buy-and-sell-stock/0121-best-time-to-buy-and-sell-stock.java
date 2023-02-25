class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int n = prices.length;
        if(n == 1){
            return 0;
        }
        
        int maxProfit = Integer.MIN_VALUE; 
        
        for(int i=1;i<n;i++){
            if(prices[i] > min){
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
            else{
                min = prices[i];
            }
        }
        
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}
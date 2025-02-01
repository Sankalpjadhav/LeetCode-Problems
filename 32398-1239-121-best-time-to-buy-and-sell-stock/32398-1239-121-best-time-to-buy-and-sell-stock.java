class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int min = prices[0];

        for(int i=1;i<n;i++){
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }
}


/*
Recursion:

public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n == 1) return 0;

        int result = helper(1, prices[0], prices, n) ;
        return result <= 0 ? 0 : result;
    }

    private int helper(int index, int min, int [] prices, int n){
        if(index == n-1){
            return prices[index] - min;
        }

        if(prices[index] < min){
            return helper(index+1, prices[index], prices, n);
        }

        return Math.max(prices[index] - min, helper(index+1, min, prices, n));
    }
*/
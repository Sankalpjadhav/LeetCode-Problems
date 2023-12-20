class Solution {
    public int buyChoco(int[] prices, int money) {
        int n = prices.length;
        int initialAmount = money;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int price = prices[i];
            if(price <= firstMin){
                secondMin = firstMin;
                firstMin = price;
            }
            else if(price < secondMin){
                secondMin = price;
            }
        }
        
        money -= (firstMin + secondMin);
        
        return money < 0 ? initialAmount : money;
    }
}
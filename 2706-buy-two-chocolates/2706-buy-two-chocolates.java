class Solution {
    public int buyChoco(int[] prices, int money) {
        int moneyLeft = money;
        Arrays.sort(prices);
        moneyLeft -= prices[0];
        moneyLeft -= prices[1];
        
        return moneyLeft >= 0 ? moneyLeft : money;
    }
}
class Solution {
    public int buyChoco(int[] prices, int money) {
        int n = prices.length;
        int initialAmount = money;
        Arrays.sort(prices);
        money -= (prices[0] + prices[1]);
        return money < 0 ? initialAmount : money;
    }
}
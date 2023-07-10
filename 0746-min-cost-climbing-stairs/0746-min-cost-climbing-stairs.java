class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        return Math.min(climbStairs(0, n, cost, memo), climbStairs(1, n, cost, memo));
    }
    
    private int climbStairs(int index, int n, int [] cost, int [] memo){
        if(index == n-1 || index == n-2){
            return cost[index];
        }
        
        if(index >= n){
            return (int) 1e9;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        int oneStep = cost[index] + climbStairs(index+1, n, cost, memo);
        int twoStep = cost[index] + climbStairs(index+2, n, cost, memo);
        
        return memo[index] = Math.min(oneStep, twoStep);
    }
}
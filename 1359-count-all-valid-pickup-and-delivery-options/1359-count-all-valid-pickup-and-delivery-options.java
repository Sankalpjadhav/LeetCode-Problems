class Solution {
    private int MOD = (int) 1e9 + 7;
    
    public int countOrders(int n) {
        long [][] memo = new long[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return (int) helper(n, n, memo);
    }
    
    private long helper(int pick, int deliver, long [][] memo){
        if(deliver < 0 || pick < 0){
            return 0;
        }
        
        if(deliver < pick){
            return 0;
        }
        
        if(pick == 0 && deliver == 0){
            return 1;
        }
        
        if(memo[pick][deliver] != -1){
            return memo[pick][deliver];
        }
        
        long ans = 0;
        
        ans += pick * helper(pick-1,deliver, memo);
        ans %= MOD;
        
        ans += (deliver-pick) * helper(pick,deliver-1, memo);
        ans %= MOD;
        
        return memo[pick][deliver] = ans;
    }
    
}
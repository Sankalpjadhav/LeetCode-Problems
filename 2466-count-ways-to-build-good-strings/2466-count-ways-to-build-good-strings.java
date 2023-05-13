class Solution {
    final int MOD = (int) 1e9+7; 
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        int [] dp = new int[high+1];
        Arrays.fill(dp, -1);
        
        for(int i=low;i<=high;i++){
            ans = (ans%MOD + helper(i, zero, one, dp)%MOD)%MOD;
        }
        return ans;
    }
    
    
    private int helper(int n, int zero, int one, int[]dp){
        if(n == 0) return 1;
        if(n < 0) return 0;
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        return dp[n] = (helper(n - zero, zero, one,  dp) + helper(n - one, zero, one,  dp))%MOD;
    }
}
//215447031
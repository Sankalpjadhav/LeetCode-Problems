class Solution {
    public int numSquares(int n) {
        if(n <= 3){
            return n;
        }
        int [] dp = new int[n+1];
        for(int i=1;i<=3;i++){
            dp[i] = i;
        }
        
        for(int i=4;i<=n;i++){
            dp[i] = i;
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }
        return dp[n];
    }
    
}

/*

Recursion:
    public int numSquares(int n) {
        int result = solve(n);
        return result;
    }
    
    private int solve(int n){
        if(n <= 3){
            return n;
        }
        
        int ans = n;
        for(int i=1; i*i<=n; i++){
            ans = Math.min(ans, 1 + solve(n-i*i));
        }
        
        return ans;
    }
    
Memoization:
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int result = solve(n, dp);
        return result;
    }
    
    private int solve(int n, int [] dp){
        if(n <= 3){
            return n;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        int ans = n;
        for(int i=1; i*i<=n; i++){
            ans = Math.min(ans, 1 + solve(n-i*i, dp));
        }
        
        return dp[n] = ans;
    }

*/
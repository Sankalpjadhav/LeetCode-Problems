class Solution {
    int helper(int n, int idx, int[][] dp)
    {
       if(n == 0 || idx == 0) return 1;
        
       if(dp[n][idx] != -1) return dp[n][idx];
        
       if(idx > n) return dp[n][idx] = helper(n, idx - 1, dp);
      
       return dp[n][idx] = Math.max((idx * helper(n - idx, idx, dp)), helper(n , idx - 1, dp));
    }
    
    int integerBreak(int n)
    {
        int [][] dp = new int[n+1][n];
        
        for(int i = 0; i < n + 1; i++)
        {
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;
        }
        
        return helper(n, n - 1, dp);
    }
    
    
}

/*
Resursion: 

    public int integerBreak(int n)
    {
      return helper(n, n - 1);
    }
    
    public int helper(int n, int idx)
    {
       if(n == 0 || idx == 0) return 1;
        
       if(idx > n) return helper(n, idx - 1);
      
       return Math.max((idx * helper(n - idx, idx)), helper(n , idx - 1));
    }
*/
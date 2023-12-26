class Solution {
    final int MOD = (int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        int [][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        
        for(int i=1;i<n+1;i++){
            for(int tar=0;tar<=target;tar++){
                int numberOfWays = 0;
                for(int j=1;j<=k;j++){
                    if(tar-j >= 0){
                        numberOfWays = (numberOfWays + dp[i-1][tar-j]) % MOD;
                    }
                    else{
                        break;
                    }
                }

                dp[i][tar] = numberOfWays;
            }
        }
        return dp[n][target];
    }
    
}


/*

Recursion:

    final int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        return helper(n, k, target);
    }
    
    private int helper(int n, int k, int target){
        if(n == 0){
            if(target == 0){
                return 1;
            }
            
            return 0;
        }
        
        int numberOfWays = 0;
        for(int i=1;i<=k;i++){
            if(target-i >= 0){
                numberOfWays = (numberOfWays + helper(n-1, k, target-i)) % MOD;
            }
            else{
                break;
            }
        }
        
        return numberOfWays;
    }
    
Memoization:

    final int MOD = (int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        int [][] memo = new int[n+1][target+1];
        
        for(int i=0;i<n+1;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(n, k, target, memo);
    }
    
    private int helper(int n, int k, int target, int [][] memo){
        if(n == 0){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        
        int numberOfWays = 0;
        for(int i=1;i<=k;i++){
            if(target-i >= 0){
                numberOfWays = (numberOfWays + helper(n-1, k, target-i, memo)) % MOD;
            }
            else{
                break;
            }
        }
        
        return memo[n][target] = numberOfWays;
    }

*/
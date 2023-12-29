class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d){
            return -1;
        }
        int [][] memo = new int[n][d+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(0, n, jobDifficulty, d, memo);
    }
    
    private int helper(int index, int n, int [] jobDifficulty, int d, int [][] memo){
        if(d == 0 && index == n){
            return 0;
        }
        
        if(d == 0 || index == n || n-index < d){
            return (int)1e9;
        }
        
        if(memo[index][d] != -1){
            return memo[index][d];
        }
        
        int ans = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = index; i < n; i++){
            max = Math.max(max, jobDifficulty[i]);
            ans = Math.min(ans, max + helper(i+1, n, jobDifficulty, d-1, memo));
        }
        return memo[index][d] = ans;
    }
}

/*

Recursion:
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d){
            return -1;
        }
        
        return helper(0, n, jobDifficulty, d);
    }
    
    private int helper(int index, int n, int [] jobDifficulty, int d){
        if(d == 0 && index == n){
            return 0;
        }
        
        if(d == 0 || index == n || n-index < d){
            return (int)1e9;
        }
        
        
        int ans = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = index; i < n; i++){
            max = Math.max(max, jobDifficulty[i]);
            ans = Math.min(ans, max + helper(i+1, n, jobDifficulty, d-1));
        }
        return ans;
    }
    

*/
class Solution {
    private static final int MOD = (int) 1e9 + 7;
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }

        int res = m*n; // Every cell in a grid contribute to ans as it is path of length 1

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += helper(i, j, grid, memo);
                res %= MOD; 
            }
        }
        return res % MOD;
    }
    
    private int helper(int i, int j, int[][] grid, int [][] memo) {     
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return 0;

        if(memo[i][j]!=-1){
            return memo[i][j];
        }
    
        int count = 0;
        
        // Up
        if(i > 0 && grid[i][j] < grid[i-1][j])
            count += helper(i-1, j, grid, memo) + 1;
        
        // Down
        if(i < grid.length-1 && grid[i][j] < grid[i+1][j])
            count += helper(i+1, j, grid, memo) + 1;        
        
        // Left
         if(j > 0 && grid[i][j] < grid[i][j-1])
            count += helper(i, j-1, grid, memo) + 1;
        
        // Right
        if(j < grid[i].length-1 && grid[i][j] < grid[i][j+1])
            count += helper(i, j+1, grid, memo) + 1;
        
        return memo[i][j] = count % MOD;
    }
}

/*
    RECURSION gives TLE : 34 / 36 testcases passed

    private static final int MOD = (int) 1e9 + 7;
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = m*n; // Every cell in a grid contribute to ans as it is path of length 1

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += helper(i, j, grid) % MOD; 
            }
        }
        return res % MOD;
    }
    
    private int helper(int i, int j, int[][] grid) {     
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return 0;

        int count = 0;
        
        // Up
        if(i > 0 && grid[i][j] < grid[i-1][j])
            count += helper(i-1, j, grid) + 1;
        
        // Down
        if(i < grid.length-1 && grid[i][j] < grid[i+1][j])
            count += helper(i+1, j, grid) + 1;        
        
        // Left
         if(j > 0 && grid[i][j] < grid[i][j-1])
            count += helper(i, j-1, grid) + 1;
        
        // Right
        if(j < grid[i].length-1 && grid[i][j] < grid[i][j+1])
            count += helper(i, j+1, grid) + 1;
        
        return count % MOD;
    }   
*/
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int moves = 0;
        
        int [][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        
        for(int row=0; row<m; row++){
            int result = helper(row, 0, m, n, grid, dp);
            moves = Math.max(moves, result);
        }
        
        return moves;
    }
    
    private int helper(int row, int col, int m, int n, int [][] grid, int [][] dp){
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int up = 0;
        if(row-1 >= 0 && col+1 < n && grid[row][col] < grid[row-1][col+1]){
            up = 1 + helper(row-1, col+1, m, n, grid, dp);
        }
        
        int right = 0;
        if(row < m && col+1 < n && grid[row][col] < grid[row][col+1]){
            right = 1 + helper(row, col+1, m, n, grid, dp);
        }
        
        int down = 0;
        if(row+1 < m && col+1 < n && grid[row][col] < grid[row+1][col+1]){
            down = 1 + helper(row+1, col+1, m, n, grid, dp);
        }
        
        return dp[row][col] = Math.max(up, Math.max(right, down));
    }
}

/*
[[187,167,209,251,152,236,263,128,135],
   [267,249,251,285,73,204,70,207,74],
   [189,159,235,66,84,89,153,111,189],
   [120,81,210,7,2,231,92,128,218],
   [193,131,244,293,284,175,226,205,245]]
*/
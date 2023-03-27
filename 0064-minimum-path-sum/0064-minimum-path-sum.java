class Solution {
    public int minPathSum(int[][] grid) {
        int [][] memo = new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(0, 0, grid, memo);
    }
    
    private int helper(int i, int j, int [][] grid, int [][] memo){
        if(i==grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return (int)1e9;
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        int down = grid[i][j] + helper(i+1, j, grid, memo);
        int right = grid[i][j] + helper(i, j+1, grid, memo);
        
        return memo[i][j] = Math.min(down, right);
    }
    
}

/*
Recursion: TLE

    public int minPathSum(int[][] grid) {
        return helper(0, 0, 0, grid);
    }
    
    private int helper(int i, int j, int sum, int [][] grid){
        if(i==grid.length-1 && j == grid[0].length-1){
            return sum + grid[i][j];
        }
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return (int)1e10;
        }
        
        int down = helper(i+1, j, grid[i][j]+sum, grid);
        int right = helper(i, j+1, grid[i][j]+sum, grid);
        
        return Math.min(down, right);
    }
*/
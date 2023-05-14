class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean [][] visited = new boolean[m][n];
        int maxNumberOfFish = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] > 0 && !visited[i][j]){
                    maxNumberOfFish = Math.max(maxNumberOfFish, helper(i, j, visited, m, n, grid));
                }
            }
        }
        
        return maxNumberOfFish;
    }
    
    private int helper(int row, int col, boolean [][] visited, int m, int n, int [][] grid){
        
        visited[row][col] = true;
        
        // Left
        int left = 0;
        if(col - 1 >= 0 && !visited[row][col-1] && grid[row][col-1] > 0){
            left = helper(row, col-1, visited, m, n, grid);
        }
        
        // Down 
        int down = 0;
        if(row + 1 < m && !visited[row+1][col] && grid[row+1][col] > 0){
            down = helper(row+1, col, visited, m, n, grid);
        }
        
        // Right
        int right = 0;
        if(col + 1 < n && !visited[row][col+1] && grid[row][col+1] > 0){
            right = helper(row, col+1, visited, m, n, grid);
        }
        
        // Top
        int top = 0;
        if(row - 1 >= 0 && !visited[row-1][col] && grid[row-1][col] > 0){
            top = helper(row-1, col, visited, m, n, grid);
        }
        
        return grid[row][col] + top + left + down + right;
    }
}
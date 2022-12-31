class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numberOfZeros = 0;
        int startX = 0; 
        int startY = 0; 
        
        for(int r = 0; r < m; r++){ 
            for(int c = 0; c < n; c++){ 
                if(grid[r][c] == 0){
                    numberOfZeros++;
                } 
                else if(grid[r][c] == 1){
                    startX = r;
                    startY = c;
                }
            }
        }
        return dfs(grid, startX, startY, numberOfZeros);
    }
    public int dfs(int grid[][], int x, int y, int numberOfZeros){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1){
            return 0;
        }
        
        if(grid[x][y] == 2){
            return numberOfZeros == -1 ? 1 : 0; // zero = -1, because when we reach the final cell we are covering one cell extra then the zero count.
        }

        grid[x][y] = -1;
        
        int totalPaths = 0;
        
        totalPaths += dfs(grid, x + 1, y, numberOfZeros-1);
        totalPaths += dfs(grid, x - 1, y, numberOfZeros-1); 
        totalPaths += dfs(grid, x, y + 1, numberOfZeros-1);
        totalPaths += dfs(grid, x, y - 1, numberOfZeros-1);
        
        grid[x][y] = 0;
        
        return totalPaths;
    }
    
    
}

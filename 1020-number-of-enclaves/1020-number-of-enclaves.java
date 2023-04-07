class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int [][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j] == 1){
                        int [] count = {0};
                        dfs(i, j, grid, count, directions);
                    }
                }
            }
        }
        
        int numberOfLandsCells = 0;
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
               if(grid[i][j] == 1){
                   int [] count = {0};
                   dfs(i, j, grid, count, directions);
                   numberOfLandsCells += count[0];
               } 
            }
        }
        
        return numberOfLandsCells;
    }
    
    private void dfs(int i, int j, int [][] grid, int [] count, int [][] directions){
        grid[i][j] = 0;
        count[0]++;
    
        for(int k=0;k<4;k++){
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            
            if(isValid(newX, newY, grid)){
                dfs(newX, newY, grid, count, directions);
            }
        }
    }
    
    private boolean isValid(int i, int j, int [][] grid){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j] == 1){
            return true;
        }
        
        return false;
    }
}
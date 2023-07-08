class Solution {
    public int equalPairs(int[][] grid) {
        // Brute Force
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean isSame = true;
                for(int row=0;row<m;row++){
                    if(grid[i][row] != grid[row][j]){
                        isSame = false;
                        break;
                    }
                }
                if(isSame == true){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
}
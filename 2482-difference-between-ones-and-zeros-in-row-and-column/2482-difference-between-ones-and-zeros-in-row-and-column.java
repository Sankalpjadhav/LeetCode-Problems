class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int [] numOfOnesInRows = new int[m];
        int [] numOfOnesInCols = new int[n];
        int [] numOfZerosInRows = new int[m];
        int [] numOfZerosInCols = new int[n];
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    numOfOnesInRows[i]++;
                    numOfOnesInCols[j]++;
                }
                else{
                    numOfZerosInRows[i]++;
                    numOfZerosInCols[j]++;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = numOfOnesInRows[i] + numOfOnesInCols[j] - numOfZerosInRows[i] - numOfZerosInCols[j];
            }
        }
        
        return grid;
    }
}
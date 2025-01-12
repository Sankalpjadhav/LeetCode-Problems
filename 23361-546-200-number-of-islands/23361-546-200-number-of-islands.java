class Solution {
    private int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int numberOfIslands = 0;
        boolean [][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, m, n, grid, visited);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void dfs(int i, int j, int m, int n, char [][] grid, boolean [][] visited){
        if(grid[i][j] == '0'){
            return;
        }

        visited[i][j] = true;

        for(int [] direction: directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]){
                dfs(newI, newJ, m, n, grid, visited);
            }
        }
    }
}
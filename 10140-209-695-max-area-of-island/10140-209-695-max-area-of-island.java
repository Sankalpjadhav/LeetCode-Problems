class Solution {
    private int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean [][] visited = new boolean[m][n];

        int area = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    area = dfs(i, j, m, n, visited, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j, int m, int n, boolean [][] visited, int [][] grid){
        if(grid[i][j] == 0) return 0;

        visited[i][j] = true;
        int area = 1;

        for(int [] direction: directions)
        {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if(newI >=0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]){
                area += dfs(newI, newJ, m, n, visited, grid);
            }
        }
        return area;
    }
}
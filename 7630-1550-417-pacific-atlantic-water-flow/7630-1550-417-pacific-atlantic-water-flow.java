class Solution {
    private int [][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean [][] pacific = new boolean[m][n];
        boolean [][] atlantic = new boolean[m][n];

        for (int c = 0; c < n; c++) {
            dfs(0, c, pacific, heights, m, n);
            dfs(m - 1, c, atlantic, heights, m, n);
        }
        for (int r = 0; r < m; r++) {
            dfs(r, 0, pacific, heights, m, n);
            dfs(r, n - 1, atlantic, heights, m, n);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, boolean [][] ocean, int [][] heights, int m, int n){
        ocean[i][j] = true;
        for(int [] direction: directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && !ocean[newI][newJ] && heights[newI][newJ] >= heights[i][j]){
                dfs(newI, newJ, ocean, heights, m, n);    
            }
        }
    }
}
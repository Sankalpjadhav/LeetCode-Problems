class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int dp[][][] = new int[n][m][m];

        for(int j1 = 0; j1 < m; j1++) {
            for(int j2 = 0; j2 < m; j2++) {
                if(j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j1 = 0; j1 < m; j1++) {
                for(int j2 = 0; j2 < m; j2++) {
                    int maxi = (int) -1e9;
                    
                    for(int a = -1; a <= 1; a++) {
                        for(int b = -1; b <= 1; b++) {
                            if(j1 + a >= 0 && j1 + a < m && j2 + b >= 0 && j2 + b < m) {
                                if(j1 == j2)
                                    maxi = Math.max(maxi, grid[i][j1] + dp[i + 1][j1 + a][j2 + b]);
                                else
                                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + dp[i + 1][j1 + a][j2 + b]);
                            }
                        }
                    }

                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m - 1];
    }
}
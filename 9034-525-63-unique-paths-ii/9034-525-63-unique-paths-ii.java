class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0; // If there is a obstacle at the bottom right corner then its 0
        int [] next = new int[n];
        for(int row=m-1;row>=0;row--){
            int [] current = new int[n];
            for(int col=n-1;col>=0;col--){
                if(row == m-1 && col == n-1){
                    current[col] = 1;
                }
                else{
                    int right = 0;
                    if(col+1 < n && obstacleGrid[row][col] == 0){
                        right = current[col+1];
                    }
                    int down = 0;
                    if(row+1 < m && obstacleGrid[row][col] == 0){
                        down = next[col];
                    }
                    current[col] = right + down;
                }
            }
            next = current;
        }
        return next[0];
    }
}

/*
Tabulation: TC: O(m*n), SC: O(m*n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0; // If there is a obstacle at the bottom right corner then its 0
        int [][] dp = new int[m][n];
        for(int row=m-1;row>=0;row--){
            for(int col=n-1;col>=0;col--){
                if(row == m-1 && col == n-1){
                    dp[row][col] = 1;
                }
                else{
                    int right = 0;
                    if(col+1 < n && obstacleGrid[row][col] == 0){
                        right = dp[row][col+1];
                    }
                    int down = 0;
                    if(row+1 < m && obstacleGrid[row][col] == 0){
                        down = dp[row+1][col];
                    }
                    dp[row][col] = right + down;
                }
            }
        }
        return dp[0][0];
    }

Memoization: Time complexity: O(m*n), Space complexity: O(m*n) + O(m + n)

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(0, 0, m, n, memo, obstacleGrid);
    }

    private int helper(int row, int col, int m, int n, int [][] memo, int [][] grid){
        if(row == m-1 && col == n-1 && grid[row][col] == 0){
            return 1;
        }

        if(row >= m || col >= n || grid[row][col] == 1){
            return 0;
        }

        if(memo[row][col] != -1){
            return memo[row][col];
        }

        int right = helper(row, col+1, m, n, memo, grid);
        int down = helper(row+1, col, m, n, memo, grid);

        return memo[row][col] = right + down;
    }


Recursion: TC: O(2^(m*n)), SC: O(m+n) for recursion stack space
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return helper(0, 0, m, n, obstacleGrid);
    }

    private int helper(int row, int col, int m, int n, int [][] grid){
        if(row == m-1 && col == n-1 && grid[row][col] == 0){
            return 1;
        }

        if(row >= m || col >= n || grid[row][col] == 1){
            return 0;
        }

        int right = helper(row, col+1, m, n, grid);
        int down = helper(row+1, col, m, n, grid);

        return right + down;
    }
*/
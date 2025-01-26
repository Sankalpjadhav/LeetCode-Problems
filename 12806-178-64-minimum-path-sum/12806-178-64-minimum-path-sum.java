class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [] next = new int[n];

        for(int row=m-1;row>=0;row--){
            int [] current = new int[n];
            for(int col=n-1;col>=0;col--){
                if(row == m-1 && col == n-1){
                    current[col] = grid[row][col];
                }
                else{
                    int right = grid[row][col];
                    if(col+1 < n){
                        right += current[col+1];
                    }
                    else{
                        right += (int)1e6;
                    }
                    int down = grid[row][col];
                    if(row+1 < m){
                        down += next[col];
                    } 
                    else{
                        down += (int)1e6;
                    }
                    current[col] = Math.min(right, down);
                }
            }
            next = current;
        }
        
        return next[0];
    }
}

/*
Tabulation: TC: O(m*n), SC: O(m*n)

public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];

        for(int row=m-1;row>=0;row--){
            for(int col=n-1;col>=0;col--){
                if(row == m-1 && col == n-1){
                    dp[row][col] = grid[row][col];
                }
                else{
                    int right = grid[row][col];
                    if(col+1 < n){
                        right += dp[row][col+1];
                    }
                    else{
                        right += (int)1e6;
                    }
                    int down = grid[row][col];
                    if(row+1 < m){
                        down += dp[row+1][col];
                    } 
                    else{
                        down += (int)1e6;
                    }
                    dp[row][col] = Math.min(right, down);
                }
            }
        }
        
        return dp[0][0];
    }

Memoization: TC: O(m*n), SC: O(m*n) + O(m + n)
public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }
        return findMinimumPathSum(0, 0, m, n, memo, grid);
    }

    private int findMinimumPathSum(int row, int col, int m, int n, int [][] memo, int [][] grid){
        if(row == m-1 && col == n-1){
            return grid[row][col];
        }

        if(row >= m || col >= n){
            return (int)1e6; // Return some high value which is greater than given constraint
        }

        if(memo[row][col] != -1) return memo[row][col];

        int right = grid[row][col] + findMinimumPathSum(row, col+1, m, n, memo, grid);
        int down = grid[row][col] + findMinimumPathSum(row+1, col, m, n, memo, grid);

        return memo[row][col] = Math.min(right, down);
    }

Recursion: TC: (2^(m*n)), SC: O(m+n) 

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return findMinimumPathSum(0, 0, m, n, grid);
    }

    private int findMinimumPathSum(int row, int col, int m, int n, int [][] grid){
        if(row == m-1 && col == n-1){
            return grid[row][col];
        }

        if(row >= m || col >= n){
            return (int)1e6; // Return some high value which is greater than given constraint
        }

        int right = grid[row][col] + findMinimumPathSum(row, col+1, m, n, grid);
        int down = grid[row][col] + findMinimumPathSum(row+1, col, m, n, grid);

        return Math.min(right, down);
    }
*/
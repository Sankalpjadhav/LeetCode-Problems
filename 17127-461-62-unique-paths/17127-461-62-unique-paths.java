class Solution {
    public int uniquePaths(int m, int n) {
        int [] next = new int[n];

        for(int i=m-1;i>=0;i--){
            int [] current = new int[n];
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    current[j] = 1;
                }
                else{
                    int right = 0;
                    if(j+1 < n){
                        right = current[j+1];
                    }
                    int bottom = 0;
                    if(i+1 < m){
                        bottom = next[j];
                    }
                    current[j] = right + bottom;
                }
            }
            next = current;
        }

        return next[0];
    }
}

/*
Tabulation: TC: O(m*n), SC: O(m*n)

 public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j] = 1;
                }
                else{
                    int right = 0;
                    if(j+1 < n){
                        right = dp[i][j+1];
                    }
                    int bottom = 0;
                    if(i+1 < m){
                        bottom = dp[i+1][j];
                    }
                    dp[i][j] = right + bottom;
                }
            }
        }

        return dp[0][0];
    }


Memoization: Time complexity: O(m*n), Space complexity: O(m + n) + O(m*n)

public int uniquePaths(int m, int n) {
        int [][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j] = -1;
            }
        }
        return totalPaths(0, 0, m, n, memo);
    }

    private int totalPaths(int row, int col, int m, int n, int [][] memo){
        if(row == m-1 && col == n-1){
            return 1;
        }

        if(row < 0 || col < 0 || row >= m || col >= n){
            return 0;
        }

        if(memo[row][col] != -1){
            return memo[row][col];
        }

        int right = totalPaths(row, col+1, m, n, memo);
        int bottom = totalPaths(row+1, col, m, n, memo);

        return memo[row][col] = right + bottom;
    }

Recursion: Time complexity: O(2 ^ (m*n)), Space complexity: O(m + n)
    public int uniquePaths(int m, int n) {
        return totalPaths(0, 0, m, n);
    }

    private int totalPaths(int row, int col, int m, int n){
        if(row == m-1 && col == n-1){
            return 1;
        }

        if(row < 0 || col < 0 || row >= m || col >= n){
            return 0;
        }

        int right = totalPaths(row, col+1, m, n);
        int bottom = totalPaths(row+1, col, m, n);

        return right + bottom;
    }
*/
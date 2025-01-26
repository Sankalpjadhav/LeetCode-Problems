class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [] next = new int[n];

        for(int col=0;col<n;col++){
            next[col] = matrix[n-1][col];
        }

        for(int row=n-2;row>=0;row--){
            int [] current = new int[n];
            for(int col=n-1;col>=0;col--){
                int down = matrix[row][col] + next[col];
                int downLeft = matrix[row][col];
                if(col-1 >= 0){
                    downLeft += next[col-1];
                }
                else{
                    downLeft = (int)1e6;
                } 
                int downRight = matrix[row][col];
                if(col+1 < n){
                    downRight += next[col+1];
                }
                else{
                    downRight = (int)1e6;
                }

                current[col] = Math.min(down, Math.min(downLeft, downRight));
            }
            next = current;
        }

        int min = Integer.MAX_VALUE;

        for(int col=0;col<n;col++){
            min = Math.min(min, next[col]);
        }

        return min;
    }
}

/*
Tabulation: TC: O(m*n), SC: O(m*n)
public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [][] dp = new int[n][n];

        for(int col=0;col<n;col++){
            dp[n-1][col] = matrix[n-1][col];
        }

        for(int row=n-2;row>=0;row--){
            for(int col=n-1;col>=0;col--){
                int down = matrix[row][col] + dp[row+1][col];
                int downLeft = matrix[row][col];
                if(col-1 >= 0){
                    downLeft += dp[row+1][col-1];
                }
                else{
                    downLeft = (int)1e6;
                } 
                int downRight = matrix[row][col];
                if(col+1 < n){
                    downRight += dp[row+1][col+1];
                }
                else{
                    downRight = (int)1e6;
                }

                dp[row][col] = Math.min(down, Math.min(downLeft, downRight));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int col=0;col<n;col++){
            min = Math.min(min, dp[0][col]);
        }

        return min;
    }


Memoization: TC: O(m*n), SC: O(m)
public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int [][] memo = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }

        for(int col=0;col<n;col++){
            min = Math.min(min, findMinimum(0, col, n, matrix, memo));
        }
        return min;
    }

    private int findMinimum(int row, int col, int n, int [][] matrix, int [][] memo){
        if(col < 0 || col >= n) return (int)1e6;
        if(row == n-1){
            return matrix[row][col];
        }

        if(memo[row][col] != -1) return memo[row][col];

        int down = matrix[row][col] + findMinimum(row+1, col, n, matrix, memo);
        int downLeft = matrix[row][col] + findMinimum(row+1, col-1, n, matrix, memo);
        int downRight = matrix[row][col] + findMinimum(row+1, col+1, n, matrix, memo);

        return memo[row][col] = Math.min(down, Math.min(downLeft, downRight));
    }

Recursion: TC: O(3^(n*n)), SC: O(n)

public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for(int col=0;col<n;col++){
            min = Math.min(min, findMinimum(0, col, n, matrix));
        }
        return min;
    }

    private int findMinimum(int row, int col, int n, int [][] matrix){
        if(col < 0 || col >= n) return (int)1e6;
        if(row == n-1){
            return matrix[row][col];
        }

        int down = matrix[row][col] + findMinimum(row+1, col, n, matrix);
        int downLeft = matrix[row][col] + findMinimum(row+1, col-1, n, matrix);
        int downRight = matrix[row][col] + findMinimum(row+1, col+1, n, matrix);

        return Math.min(down, Math.min(downLeft, downRight));
    }
*/
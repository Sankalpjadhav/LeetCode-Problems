class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int [][] dp = new int[m][n];
        
        for(int j=0;j<n;j++){
            dp[m-1][j] = matrix[m-1][j];
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int leftDiagonal = (int)1e9;
                if(j-1 >= 0){
                    leftDiagonal = matrix[i][j] + dp[i+1][j-1];
                }

                int rightDiagonal = (int)1e9;
                if(j+1 < matrix[0].length){
                    rightDiagonal = matrix[i][j] + dp[i+1][j+1];
                }

                int down =  matrix[i][j] + dp[i+1][j];

                dp[i][j] = Math.min(leftDiagonal, Math.min(rightDiagonal, down));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}


/*
Memoization:

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        int [][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }

        for(int i=0;i<n;i++){
            min = Math.min(min, helper(0, i, matrix, memo));
        }

        return min;
    }

    private int helper(int i, int j, int [][] matrix, int [][] memo){
        if(i == matrix.length-1){
            return matrix[i][j];
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int leftDiagonal = (int)1e9;
        if(j-1 >= 0){
            leftDiagonal = matrix[i][j] + helper(i+1, j-1, matrix, memo);
        }

        int rightDiagonal = (int)1e9;
        if(j+1 < matrix[0].length){
            rightDiagonal = matrix[i][j] + helper(i+1, j+1, matrix, memo);
        }

        int down =  matrix[i][j] + helper(i+1, j, matrix, memo);

        return memo[i][j] = Math.min(leftDiagonal, Math.min(rightDiagonal, down));
    }

*/
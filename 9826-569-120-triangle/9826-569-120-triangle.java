class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int [] next = new int[n];
        for(int j=0;j<n;j++){
            next[j] = triangle.get(m-1).get(j);
        }
        for(int row=m-2;row>=0;row--){
            int [] current = new int[n];
            for(int col=triangle.get(row).size()-1;col>=0;col--){
                int down = triangle.get(row).get(col) + next[col];
                int downRight = triangle.get(row).get(col);
                if(col+1 < triangle.get(row+1).size()){
                    downRight += next[col+1];
                }
                else{
                    downRight = (int)1e7;
                }
                current[col] = Math.min(down, downRight);
            }
            next = current;
        }
        return next[0];
    }

    
}

/*
Tabulation: TC: O(m*n), SC: O(m*n)

public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int [][] dp = new int[m][n];
        for(int j=0;j<n;j++){
            dp[m-1][j] = triangle.get(m-1).get(j);
        }
        for(int row=m-2;row>=0;row--){
            for(int col=triangle.get(row).size()-1;col>=0;col--){
                int down = triangle.get(row).get(col) + dp[row+1][col];
                int downRight = triangle.get(row).get(col);
                if(col+1 < triangle.get(row+1).size()){
                    downRight += dp[row+1][col+1];
                }
                else{
                    downRight = (int)1e7;
                }
                dp[row][col] = Math.min(down, downRight);
            }
        }
        return dp[0][0];
    }

Memoization: TC: O(m*n), SC: O(m*n) + O(m)

public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int [][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }
        return findMinimum(0, 0, m, n, memo, triangle);
    }

    private int findMinimum(int row, int col, int m, int n, int [][] memo, List<List<Integer>> triangle){
        if(row == m-1){
            return triangle.get(row).get(col);
        }

        if(col > triangle.get(row).size()){
            return (int)1e7;
        }

        if(memo[row][col] != -1){
            return memo[row][col];
        }

        int down = triangle.get(row).get(col) + findMinimum(row+1, col, m, n, memo, triangle);
        int downRight = triangle.get(row).get(col) + findMinimum(row+1, col+1, m, n, memo, triangle);

        return memo[row][col] = Math.min(down, downRight);
    }


Recursion: TC: O(2^(m*n)), SC: O(m) for recursion stack space.

public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        return findMinimum(0, 0, m, n, triangle);
    }

    private int findMinimum(int row, int col, int m, int n, List<List<Integer>> triangle){
        if(row == m-1){
            return triangle.get(row).get(col);
        }

        if(col > triangle.get(row).size()){
            return (int)1e7;
        }

        int down = triangle.get(row).get(col) + findMinimum(row+1, col, m, n, triangle);
        int downRight = triangle.get(row).get(col) + findMinimum(row+1, col+1, m, n, triangle);

        return Math.min(down, downRight);
    }
*/
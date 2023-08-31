class Solution {
    // Space optimised solution to O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int [][] memo = new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }
        return minTopDown(triangle, 0, 0, triangle.get(0).get(0), memo);
    }

    public int minTopDown(List<List<Integer>> triangle, int row, int col, int sum, int [][] memo){
        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(memo[row][col] != -1){
            return memo[row][col];
        }
        int rowMin = Math.min(minTopDown(triangle, row+1, col, triangle.get(row+1).get(col), memo), minTopDown(triangle, row+1, col+1, triangle.get(row+1).get(col+1), memo));
        
        return memo[row][col] = sum + rowMin;
    }
    
}


/*
Recursion
public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        return helper(0, 0, triangle);
    }
    
    private int helper(int i, int j, List<List<Integer>> triangle){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        
        
        int down = triangle.get(i).get(j) + helper(i+1, j, triangle);
        int diagonal = triangle.get(i).get(j) + helper(i+1, j+1, triangle);
        
        return Math.min(down, diagonal);
        
    }
    
Memoization

public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int [][] dp = new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, triangle, dp);
    }
    
    private int helper(int i, int j, List<List<Integer>> triangle, int [][] dp){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        
        // Memo
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int down = triangle.get(i).get(j) + helper(i+1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + helper(i+1, j+1, triangle, dp);
        
        return dp[i][j] = Math.min(down, diagonal);
        
    }
    
    
Tabulation
public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int [][] dp = new int [m][n];
        for(int j=0;j<n;j++){
            dp[m-1][j] = triangle.get(m-1).get(j);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                 int down = triangle.get(i).get(j) + dp[i+1][j];
                 int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];

                 dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

*/
class Solution {
    // Space optimised solution to O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int [] next = new int[n];
        for(int j=0;j<n;j++){
            next[j] = triangle.get(m-1).get(j);
        }
        for(int i=m-2;i>=0;i--){
            int [] curr = new int[n];
            for(int j=i;j>=0;j--){
                 int down = triangle.get(i).get(j) + next[j];
                 int diagonal = triangle.get(i).get(j) + next[j+1];

                 curr[j] = Math.min(down, diagonal);
            }
            next = curr;
        }
        return next[0];
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
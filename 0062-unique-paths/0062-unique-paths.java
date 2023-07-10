class Solution {
    public int uniquePaths(int m, int n) {
        int [][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }
        return findUniquePaths(0, 0, m, n, memo);
    }
    
    private int findUniquePaths(int index1, int index2, int m, int n, int [][] memo){
        if(index1 == m || index2 == n){
            return 0;
        }
        
        if(index1 == m-1 && index2 == n-1){
            return 1;
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        int rightPath = findUniquePaths(index1, index2+1, m, n, memo);
        int downPath = findUniquePaths(index1+1, index2, m, n, memo);
        
        return memo[index1][index2] = rightPath + downPath;
    }
}
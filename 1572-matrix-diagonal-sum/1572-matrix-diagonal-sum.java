class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int m = mat.length;
        int n = mat[0].length;
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i ==  j){
                    sum += mat[i][j];
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(i == n-j-1){
                    sum += mat[i][j];
                }
            }
        }
        
        if(m % 2 == 1){
            int mid = m / 2;
            sum -= mat[mid][mid];
        }
        
        return sum;
    }
}
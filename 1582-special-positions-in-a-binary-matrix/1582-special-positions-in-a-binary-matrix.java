class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int [] row = new int[n];
        int [] col = new int[m];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1){
                    row[j]++;
                    col[i]++;
                }
            }
        }
        
        int count = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1){
                    if(row[j] == 1 && col[i] == 1){
                        count++;
                    }
                }
            }
        }
        
        return count;
        
    }
}
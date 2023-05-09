class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        
        int num = 1;
        
        int top = 0, bottom = n-1, left = 0, right = n-1;
        
        int direction = 0;
        
        while(top <= bottom && left <= right){
            if(direction == 0){
                for(int i=left;i<=right;i++){
                    matrix[top][i] = num;
                    num += 1;
                }
                top++;
                direction = 1;
            }   
            else if(direction == 1){
                for(int i=top;i<=bottom;i++){
                    matrix[i][right] = num;
                    num += 1;
                }
                right--;
                direction = 2;
            }
            else if(direction == 2){
                for(int i=right;i>=left;i--){
                    matrix[bottom][i] = num;
                    num += 1;
                }
                bottom--;
                direction = 3;
            } 
            else if(direction == 3){
                for(int i=bottom;i>=top;i--){
                    matrix[i][left] = num;
                    num += 1;
                }
                left++;
                direction = 0;
            }
        }
        
        return matrix;
    }
}
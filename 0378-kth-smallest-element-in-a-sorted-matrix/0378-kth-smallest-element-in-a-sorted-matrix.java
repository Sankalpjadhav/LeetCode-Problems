class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(findCount(matrix, mid) < k){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        
        return left;
    }
    
    private int findCount(int [][] matrix, int mid){
        int count = 0, n = matrix.length, i = n-1, j = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] > mid) i--;
            else{
                count += (i+1);
                j++;
            }
        }
        return count;
    }
}

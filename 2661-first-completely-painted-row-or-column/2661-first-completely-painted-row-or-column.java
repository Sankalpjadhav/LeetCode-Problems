class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> lookup = new HashMap<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                lookup.put(mat[i][j], new int[]{i,j});
            }
        }
        
        int R = mat.length;
        int C = mat[0].length;
        
        int [] row = new int[R];
        int [] col = new int[C];
        
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            
            int [] position = lookup.get(num);
            
            row[position[0]] += 1;
            col[position[1]] += 1;
            
            if(row[position[0]] == C || col[position[1]] == R){
                return i;
            }
        }
        
        return -1;
    }
}
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int [] counter = new int[size+1];
        int repeated = -1, missing = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num = grid[i][j];
                if(counter[num] == 1){
                    repeated = num; 
                }
                counter[num]++;
            }
        }

        for(int i=1;i<=size;i++){
            if(counter[i] == 0){
                missing = i;
                break;
            }
        }

        return new int[]{repeated, missing};
    }
}
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i = 0, j = 0;
        int n = blocks.length();
        int minOperations = Integer.MAX_VALUE;
        int whiteCounts = 0;
        
        
        while(j < n){
            if(j - i + 1 < k){
                if(blocks.charAt(j) == 'W'){
                    whiteCounts += 1;
                }
            }
            else{
                if(blocks.charAt(j) == 'W'){
                    whiteCounts += 1;
                }
                minOperations = Math.min(minOperations, whiteCounts);
                if(blocks.charAt(i) == 'W'){
                    whiteCounts--;
                }
                i++;
            }
            j++;
        }
        
        return minOperations;
    }
}
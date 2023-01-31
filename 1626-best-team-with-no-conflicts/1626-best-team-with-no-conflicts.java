class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        
        // Combine 2 arrays so that sorting 2 1D arrays wrt 1 array becomes easy.
        
        int [][] array = new int[n][2];
        
        for(int i=0;i<n;i++){
            array[i][0] = ages[i];
            array[i][1] = scores[i];
        }
        
        Arrays.sort(array, (a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        
        int best = 0;
        for(int i=0;i<n;i++){
            best = Math.max(best, helper(i, array, memo));
        }
        
        return best;
    }
    
    private int helper(int index, int [][] array, int [] memo){
        if(index == array.length){
            return 0;
        }
        
        if(memo[index]!=-1){
            return memo[index];
        }
        
        int best = array[index][1];
        
        for(int j=index+1;j<array.length;j++){
            if(array[j][1] > array[index][1] || array[j][0] == array[index][0] || array[j][1] == array[index][1]){
                best = Math.max(best, array[index][1] + helper(j, array, memo));
            }
        }
        
        return memo[index] = best;
    }
}
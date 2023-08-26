class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b)-> a[0] - b[0]);
        int [][] memo = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(0, -1, pairs, memo);
    }
    
    private int helper(int index, int prevIndex, int [][] pairs, int [][] memo){
        if(index >= pairs.length){
            return 0;
        }
        
        if(memo[index][prevIndex+1] != -1){
            return memo[index][prevIndex+1];
        }
        
        int take = (int)-1e9, notTake = (int)-1e9;
        
        if(prevIndex == -1 || pairs[prevIndex][1] < pairs[index][0]){
            take = 1 + helper(index+1, index, pairs, memo);
        }
        notTake = 0 + helper(index+1, prevIndex, pairs, memo);
        
        return memo[index][prevIndex+1] = Math.max(take, notTake);
    }

}
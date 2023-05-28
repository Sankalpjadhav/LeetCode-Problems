class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int [][] memo = new int[cuts.length][cuts.length];
        for(int i=0;i<cuts.length;i++){
            Arrays.fill(memo[i], -1);
        }
        return calculateMinCost(0, n, cuts, 0, cuts.length-1, memo);
    }
    
    private int calculateMinCost(int start, int end, int [] cuts, int cutStart, int cutEnd, int [][] memo){
        if(cutStart > cutEnd){
            return 0;
        }
        
        if(memo[cutStart][cutEnd] != -1){
            return memo[cutStart][cutEnd];
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int i=cutStart;i<=cutEnd;i++){
            minCost = Math.min(minCost, (end-start) + calculateMinCost(start, cuts[i], cuts, cutStart, i-1, memo) + calculateMinCost(cuts[i], end, cuts, i+1, cutEnd, memo));
        }
        
        return memo[cutStart][cutEnd] = minCost;
    }
}
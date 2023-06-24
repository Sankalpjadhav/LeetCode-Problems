class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int [][] memo = new int[n][5000*2];
        
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(0, 0, rods, memo);
    }
    
    private int helper(int index, int difference, int [] rods, int [][] memo){
        if(index == rods.length){
            if(difference == 0){
                return 0;
            }
            return (int)-1e7;
        }
        
        if(memo[index][difference + 5000] != -1){
            return memo[index][difference + 5000];
        }
    
        
        // 3 choices: Drop the current element OR add it to left array OR add it to right array
        int drop = helper(index+1, difference, rods, memo);
        int addToLeft = rods[index] + helper(index+1, difference + rods[index], rods, memo);
        int addToRight = helper(index+1, difference - rods[index], rods, memo);
        
        return memo[index][difference + 5000] = Math.max(drop, Math.max(addToLeft, addToRight));
    }
}
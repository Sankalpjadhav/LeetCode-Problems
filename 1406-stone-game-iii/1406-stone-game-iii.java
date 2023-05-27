class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        
        int aliceScore = helper(0, n, stoneValue, memo);
        
        //System.out.println(aliceScore);
        
        if(aliceScore == 0){
            return "Tie";
        }
        else if(aliceScore < 0){
            return "Bob";
        }
        
        return "Alice";
    }
    
    private int helper(int index, int n, int [] stoneValue, int [] memo){
        if(index >= n){
            return 0;
        }
        
        if(memo[index]!=-1){
            return memo[index];
        }
        
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=1;i<=3;i++){
            if(index+i-1 < n){
                sum += stoneValue[index+i-1];
                result = Math.max(result, sum - helper(index+i, n, stoneValue, memo));
            }
        }
        
        return memo[index] = result;
    }
}
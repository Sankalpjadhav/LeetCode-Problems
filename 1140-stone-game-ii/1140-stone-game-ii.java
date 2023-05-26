class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int M = 1;
        
        int [][] memo = new int[n][n+1];
        
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        
        int result = helper(0, M, n, piles, memo);
        
        /* 
            We need to find maximum number of stones Alice can get
            profit_alice + profit_bob = total_stones ....... eq(1)
            profit_alice - profit_bob = result       ....... eq(2)
            we add both equation 1 and 2
            2*profit_alice = total_stones + result
        */
        
        int total_stones = 0;
        
        for(int i=0;i<n;i++){
            total_stones+= piles[i];
        }
        
        int profit_alice = (total_stones + result)/2;
        return profit_alice;
    }
    
    private int helper(int index, int M, int n, int [] piles, int [][] memo){
        if(index >= n){
            return 0;
        }
        
        if(memo[index][M] != -1){
            return memo[index][M];
        }
        
        int sum = 0;
        // Player will consume all the piles on his turn if 1 to 2M consumes all the remaining piles
        if(2*M + index >= n){
            
            
            for(int i=index;i<n;i++){
                sum += piles[i];
            }
            
            return memo[index][M] = sum;
        }
        
        int value = Integer.MIN_VALUE;
        
        for(int j=1;j<=2*M;j++){
            sum += piles[index+j-1];
        
            value = Math.max(value, sum - helper(index+j, Math.max(M,j), n, piles, memo));
        }
        
        return memo[index][M] = value;
    }
}
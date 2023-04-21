class Solution {
    private int MOD = (int) 1e9 + 7;
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int G = group.length;
        int [][][] memo = new int[G][n+1][minProfit+1];
        
        for(int i=0;i<G;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        return helper(0, n, minProfit, group, profit, memo) % MOD;     
    }
    
    private int helper(int index, int peopleLeft, int profitLeft, int [] group, int [] profit, int [][][] memo){
        if(peopleLeft < 0){
            return 0;
        }
        if(profitLeft < 0){
            profitLeft = 0;
        }
        
        if(index == group.length){
            if(profitLeft == 0){
                return 1;
            }
            
            return 0;
        }
        
        if(memo[index][peopleLeft][profitLeft] != -1){
            return memo[index][peopleLeft][profitLeft];
        }
        
        long countUsingScheme = helper(index+1, peopleLeft - group[index], profitLeft - profit[index], group, profit, memo);
        
        long countWithoutScheme = helper(index+1, peopleLeft, profitLeft, group, profit, memo);
        
        return memo[index][peopleLeft][profitLeft] = (int)(countWithoutScheme + countUsingScheme) % MOD;
    }
}


/*
RECURSION:

class Solution {
    private int MOD = (int) 1e9 + 7;
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        return helper(0, n, minProfit, group, profit) % MOD;     
    }
    
    private int helper(int index, int peopleLeft, int profitLeft, int [] group, int [] profit){
        if(peopleLeft < 0){
            return 0;
        }
        if(profitLeft < 0){
            profitLeft = 0;
        }
        
        if(index == group.length){
            if(profitLeft == 0){
                return 1;
            }
            
            return 0;
        }
        
        long countUsingScheme = helper(index+1, peopleLeft - group[index], profitLeft - profit[index], group, profit);
        
        long countWithoutScheme = helper(index+1, peopleLeft, profitLeft, group, profit);
        
        return (int)(countWithoutScheme + countUsingScheme) % MOD;
    }
}
*/
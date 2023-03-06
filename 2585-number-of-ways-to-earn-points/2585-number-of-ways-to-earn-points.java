class Solution {
    private final int MOD = (int)1e9 + 7;
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int [][] memo = new int[n][target+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(0, n, 0, target, types, memo) % MOD;
    }
    
    private int helper(int index, int n, int currentSum, int target, int [][] types, int [][] memo){
        if(currentSum == target){
            return 1;
        }
        if(currentSum > target){
            return 0;
        }
        if(index == n){
            if(target == currentSum){
                return 1;
            }
            return 0;
        }
        
        if(memo[index][currentSum] != -1){
            return memo[index][currentSum];
        }
        
        
        int take = 0, notTake = 0;
        
        for(int i=1;i<=types[index][0];i++){
            take = (take + (helper(index+1, n, currentSum + i*types[index][1], target, types, memo)) % MOD) % MOD;
        }
        
        notTake = (notTake + (helper(index+1, n, currentSum, target, types, memo)) % MOD) % MOD;
            
        return memo[index][currentSum] = (take + notTake) % MOD;
    }
}


/*
Recursion: Obviously TLE : 9 / 60 test cases passed.

private final int MOD = (int)1e9 + 7;
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        return helper(0, n, 0, target, types) % MOD;
    }
    
    private int helper(int index, int n, int currentSum, int target, int [][] types){
        if(currentSum == target){
            return 1;
        }
        if(currentSum > target){
            return 0;
        }
        if(index == n){
            if(target == currentSum){
                return 1;
            }
            return 0;
        }
        
        
        int take = 0, notTake = 0;
        
        for(int i=1;i<=types[index][0];i++){
            take = (take + (helper(index+1, n, currentSum + i*types[index][1], target, types)) % MOD) % MOD;
        }
        
        notTake = (notTake + (helper(index+1, n, currentSum, target, types)) % MOD) % MOD;
            
        return (take + notTake) % MOD;
    }
*/
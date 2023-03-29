class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int [][]memo = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(0, 1, satisfaction, memo);
    }
    
    private int helper(int index, int time, int [] satisfaction, int [] []memo){
        if(index == satisfaction.length){
            return 0;
        }
        
        if(memo[index][time] != -1){
            return memo[index][time];
        }
        
        int exclude = 0 + helper(index+1, time, satisfaction, memo);
        
        int include = 0;
        for(int i=index;i<satisfaction.length;i++){
            include = Math.max(include, time * satisfaction[index] + helper(index+1, time+1, satisfaction, memo));
        }
        
        return memo[index][time] = Math.max(exclude, include);
    }
}

/*
Recursion: TLE

public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return helper(0, 1, satisfaction);
    }
    
    private int helper(int index, int time, int [] satisfaction){
        if(index == satisfaction.length){
            return 0;
        }
        
        int exclude = 0 + helper(index+1, time, satisfaction);
        
        int include = 0;
        for(int i=index;i<satisfaction.length;i++){
            include = Math.max(include, time * satisfaction[index] + helper(index+1, time+1, satisfaction));
        }
        
        return Math.max(exclude, include);
    }
*/
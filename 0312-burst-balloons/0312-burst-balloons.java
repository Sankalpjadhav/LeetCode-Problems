class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int [] A = new int[n];
        A[0] = A[n-1] = 1;
        for(int i=0; i<nums.length; i++){
            A[i+1] = nums[i];  
        }
        
        int [][] memo = new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(0, n-1, A, memo);
    }
    
    private int helper(int left, int right, int [] A, int [][] memo){
        
        if(memo[left][right]!=-1){
            return memo[left][right];
        }
        
        int maxScore = 0;
        
        for(int i=left+1; i<right; i++){
            int currentScore = A[left] * A[i] * A[right];
            maxScore = Math.max(maxScore, currentScore + helper(left, i, A, memo) + helper(i, right, A, memo));
        }
        
        return memo[left][right] = maxScore;
    }
}


/*

MEMOIZATION: GIVES TLE: 70/73 cases passed

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int [] A = new int[n];
        A[0] = A[n-1] = 1;
        for(int i=0; i<nums.length; i++){
            A[i+1] = nums[i];  
        }
        
        HashMap<String, Integer> memo = new HashMap<>();
        
        return helper(0, n-1, A, memo);
    }
    
    private int helper(int left, int right, int [] A, HashMap<String, Integer> memo){
        
        String key = left+"-"+right;
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int maxScore = 0;
        
        for(int i=left+1; i<right; i++){
            int currentScore = A[left] * A[i] * A[right];
            maxScore = Math.max(maxScore, currentScore + helper(left, i, A, memo) + helper(i, right, A, memo));
        }
        
        memo.put(key, maxScore);
        
        return maxScore;
    }
    
    

RECURSION: GIVES TLE

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int [] A = new int[n];
        A[0] = A[n-1] = 1;
        for(int i=0; i<nums.length; i++){
            A[i+1] = nums[i];  
        }
        
        return helper(0, n-1, A);
    }
    
    private int helper(int left, int right, int [] A){
        
        int maxScore = 0;
        
        for(int i=left+1; i<right; i++){
            int currentScore = A[left] * A[i] * A[right];
            maxScore = Math.max(maxScore, currentScore + helper(left, i, A) + helper(i, right, A));
        }
        
        return maxScore;
    }
*/
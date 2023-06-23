class Solution {
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        // [n][501][2] : [currentIndex][difference]
        int [][] memo = new int[n][1003];
        
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        
        return helper(0, A, n, 501, memo);
    }
    
    private int helper(int currentIndex, int [] A, int n, int difference, int [][] memo){
        if(currentIndex >= n){
            return 0;
        }
        
        if(memo[currentIndex][difference+501] != Integer.MIN_VALUE){
            return memo[currentIndex][difference+501];
        }
        
        int max = 1;
        
        if(difference == 501){
            for(int i=currentIndex+1;i<n;i++){
                max = Math.max(max, Math.max(1+helper(i, A, n, A[i]-A[currentIndex], memo), helper(i, A, n, difference, memo)));
            }
        }
        else{
            for(int i=currentIndex+1;i<n;i++){
                if(A[i] - A[currentIndex] == difference){
                    max = Math.max(max, 1 + helper(i, A, n, difference, memo));   
                }
            }
        }
        
        return memo[currentIndex][difference+501] = max;
    }
}
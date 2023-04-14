class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverseString = "";
        
        for(char ch: s.toCharArray()){
            reverseString = ch + reverseString;
        }
        
        int n = s.length();
        
        int [][] memo = new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(n-1, n-1, s, reverseString, memo);
    }
    
    private int helper(int index1, int index2, String s, String reverseString, int [][] memo){
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        // Match
        if(s.charAt(index1) == reverseString.charAt(index2)){
            return memo[index1][index2] = 1 + helper(index1-1, index2-1, s, reverseString, memo);
        }
        
        // Not Match
        return memo[index1][index2] = 0 + Math.max(helper(index1-1, index2, s, reverseString, memo), helper(index1, index2-1, s, reverseString, memo));
    }
}

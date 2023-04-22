class Solution {
    public int minInsertions(String s) {
        String reverseString = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int [][] memo = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return n - helper(s, reverseString, n-1, n-1, memo);
    }
    
    private int helper(String str1, String str2, int i, int j, int [][] memo){
        if(i < 0 ||  j < 0){
            return 0;
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        if(str1.charAt(i) == str2.charAt(j)){
            return memo[i][j] = 1 + helper(str1, str2, i-1, j-1, memo);
        }
        
        return memo[i][j] = Math.max(helper(str1, str2, i-1, j, memo), helper(str1, str2, i, j-1, memo));
    }
}
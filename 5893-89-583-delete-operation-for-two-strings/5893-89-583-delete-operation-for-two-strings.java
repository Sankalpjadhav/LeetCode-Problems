class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int [][] memo = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i], -1);
        }

        int result = helper(m, n, word1, word2, memo);
        // As there is only deletion allowed, we will delete the non common chars from both strings
        return ( m - result ) + (n - result);
    }

    private int helper(int index1, int index2, String word1, String word2, int [][] memo){
        if(index1 == 0 || index2 == 0){
            return 0;
        }

        if(memo[index1][index2] != -1) return memo[index1][index2];

        if(word1.charAt(index1-1) == word2.charAt(index2-1)){
            return memo[index1][index2] = (1 + helper(index1-1, index2-1, word1, word2, memo));
        }

        return memo[index1][index2] = Math.max(helper(index1-1, index2, word1, word2, memo), helper(index1, index2-1, word1, word2, memo));
    }
}
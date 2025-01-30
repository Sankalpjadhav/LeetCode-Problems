class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int [][] dp = new int[m+1][n+1];

        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(index1-1 >= 0 && index2-1 >= 0){
                    if(text1.charAt(index1-1) == text2.charAt(index2-1)){
                        dp[index1][index2] = 1 + dp[index1-1][index2-1];
                    }
                    else{
                        dp[index1][index2] = 0 + Math.max(dp[index1-1][index2], dp[index1][index2-1]);
                    }
                }
            }
        }

        return dp[m][n];
    }
}

/*
Memoization: TC: O(m*n), SC: O(m+n) + O(m*n)
public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int [][] memo = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }

        return findLengthOfLCA(m-1, n-1, text1, text2, memo);
    }

    private int findLengthOfLCA(int index1, int index2, String text1, String text2, int [][] memo){
        if(index1 < 0 || index2 < 0){
            return 0;
        }

        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }

        if(text1.charAt(index1) == text2.charAt(index2)){
            return memo[index1][index2] = 1 + findLengthOfLCA(index1-1, index2-1, text1, text2, memo);
        }

        return memo[index1][index2] = 0 + Math.max(findLengthOfLCA(index1-1, index2, text1, text2, memo), findLengthOfLCA(index1, index2-1, text1, text2, memo));
    }

Recursion: TC: O(2^m + 2^n), SC: O(m+n)

public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        return findLengthOfLCA(m-1, n-1, text1, text2);
    }

    private int findLengthOfLCA(int index1, int index2, String text1, String text2){
        if(index1 < 0 || index2 < 0){
            return 0;
        }

        if(text1.charAt(index1) == text2.charAt(index2)){
            return 1 + findLengthOfLCA(index1-1, index2-1, text1, text2);
        }

        return 0 + Math.max(findLengthOfLCA(index1-1, index2, text1, text2), findLengthOfLCA(index1, index2-1, text1, text2));
    }
*/
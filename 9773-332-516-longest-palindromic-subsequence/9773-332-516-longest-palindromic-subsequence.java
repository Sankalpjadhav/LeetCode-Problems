class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        
        char [] s1 = s.toCharArray();
        char [] s2 = s.toCharArray();
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            char temp = s2[left];
            s2[left] = s2[right];
            s2[right] = temp;
            left++;
            right--;
        }

        int [][] dp = new int[m+1][m+1];

        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=m;index2++){
                if(s1[index1-1] == s2[index2-1]){
                    dp[index1][index2] = (1 + dp[index1-1][index2-1]);
                }
                else{
                    dp[index1][index2] = (0 + Math.max(dp[index1-1][index2], dp[index1][index2-1]));
                }
            }
        }

        return dp[m][m];
    }
}

/*
MEMOIZATION: TC: O(m*m), SC: O(m) + O(m*m)

public int longestPalindromeSubseq(String s) {
        int m = s.length();
        
        char [] s1 = s.toCharArray();
        char [] s2 = s.toCharArray();
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            char temp = s2[left];
            s2[left] = s2[right];
            s2[right] = temp;
            left++;
            right--;
        }

        int [][] memo = new int[m+1][m+1];

        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i], -1);
        }

        return calculatePalindromicSubsequence(m, m, s1, s2, memo);
    }

    private int calculatePalindromicSubsequence(int index1, int index2, char [] s1, char [] s2, int [][] memo){
        if(index1 == 0 || index2 == 0) return 0;

        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }

        if(s1[index1-1] == s2[index2-1]){
            return memo[index1][index2] = (1 + calculatePalindromicSubsequence(index1-1, index2-1, s1, s2, memo));
        }

        return memo[index1][index2] = (0 + Math.max(calculatePalindromicSubsequence(index1-1, index2, s1, s2, memo), calculatePalindromicSubsequence(index1, index2-1, s1, s2, memo)));
    }

RECURSION: TC: O(2^m): Exponential, SC: O(m)
public int longestPalindromeSubseq(String s) {
        int m = s.length();
        
        char [] s1 = s.toCharArray();
        char [] s2 = s.toCharArray();
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            char temp = s2[left];
            s2[left] = s2[right];
            s2[right] = temp;
            left++;
            right--;
        }

        return calculatePalindromicSubsequence(m, m, s1, s2);
    }

    private int calculatePalindromicSubsequence(int index1, int index2, char [] s1, char [] s2){
        if(index1 == 0 || index2 == 0) return 0;

        if(s1[index1-1] == s2[index2-1]){
            return 1 + calculatePalindromicSubsequence(index1-1, index2-1, s1, s2);
        }

        return 0 + Math.max(calculatePalindromicSubsequence(index1-1, index2, s1, s2), calculatePalindromicSubsequence(index1, index2-1, s1, s2));
    }

*/
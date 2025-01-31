class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // First find the shortest common subsequence
        int [][] dp = new int[m+1][n+1];

        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(str1.charAt(index1-1) == str2.charAt(index2-1)){
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                }
                else{
                    dp[index1][index2] = 0 + Math.max(dp[index1-1][index2], dp[index1][index2-1]);
                }
            }
        }

        int lengthOfLongestCommonSubsequence = dp[m][n]; // These chars will be used only once in the supersequence
        int lengthOfShortestCommonSupersequence = (m+n) - lengthOfLongestCommonSubsequence;
        int i = m, j = n;
        char [] result = new char[lengthOfShortestCommonSupersequence];
        int index = lengthOfShortestCommonSupersequence - 1;
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                result[index--] = str1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                result[index--] = str1.charAt(i-1);
                i--;
            }
            else{
                result[index--] = str2.charAt(j-1);
                j--;
            }
        }

        while(i > 0){
            result[index--] = str1.charAt(i-1);
            i--;
        }

        while(j > 0){
            result[index--] = str2.charAt(j-1);
            j--;
        }

        return new String(result);
    }
}
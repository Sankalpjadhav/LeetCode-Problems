class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int [][] dp = new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] =  1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lengthOfLCS = dp[m][n];
        System.out.println(lengthOfLCS);
        int lengthOfSupersequence = (m+n) - lengthOfLCS;

        char [] result = new char[lengthOfSupersequence];
        int index = lengthOfSupersequence-1;
        int i = m, j = n;
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

/* Memoization:
    private int helper(int index1, int index2, int m, int n, String str1, String str2, int [][] memo){
        if(index1 < 0 || index2 < 0){
            return 0;
        }

        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }

        if(str1.charAt(index1) == str2.charAt(index2)){
            return memo[index1][index2] = 1 + helper(index1-1, index2-1, m, n, str1, str2, memo);
        }

        return memo[index1][index2] = Math.max(helper(index1-1, index2, m, n, str1, str2, memo), helper(index1, index2-1, m, n, str1, str2, memo));
    }
*/
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int [][] memo = new int[m][n];
        
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return calculateLCS(m-1, n-1, text1, text2, memo);
    }
    
    private int calculateLCS(int index1, int index2, String text1, String text2, int [][] memo){
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        int match = 0;
        int notMatch = 0;
        
        if(text1.charAt(index1) == text2.charAt(index2)){
            match = 1 + calculateLCS(index1-1, index2-1, text1, text2, memo);
        }
        else{
            notMatch = 0 + Math.max(calculateLCS(index1-1, index2, text1, text2, memo), calculateLCS(index1, index2-1, text1, text2, memo));
        }
        
        return memo[index1][index2] = Math.max(match, notMatch);
    }
}
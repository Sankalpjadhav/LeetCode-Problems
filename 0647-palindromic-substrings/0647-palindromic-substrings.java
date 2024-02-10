class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int count=0;
        for(int diagonal=0;diagonal<dp.length;diagonal++){
            for(int i=0,j=diagonal;j<dp.length;i++,j++){
                if(diagonal==0){
                    dp[i][j] = true;
                }
                else if(diagonal==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }
                    else{
                        // By default we have false   
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }
                    else{
                        // By default we have false   
                    }
                }
                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count; 
    }
}
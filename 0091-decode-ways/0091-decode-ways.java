class Solution {
    public int numDecodings(String s) {
        int N = s.length();
        if(N==1){
            if(s.charAt(0)=='0'){
                return 0;
            }
            else{
                return 1;
            }
        }
        int [] dp = new int[N+1];
        dp[N] = 1;
        
        for(int index = N-1; index>=0; index--){
            if(s.charAt(index)=='0'){
                dp[index] = 0;
            }
            else{
                int way1 = dp[index+1];
                int way2 = 0;
                if(index < s.length()-1 && Integer.parseInt(s.substring(index, index+2)) <= 26){
                    way2 = dp[index+2];
                }
                dp[index] = way1 + way2;
            }
        }
        return dp[0];
    }
    
}


/*
Recursion:

public int numDecodings(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='0'){
                return 0;
            }
            else{
                return 1;
            }
        }
        return helper(s, 0);
    }
    
    private int helper(String s, int index){
        if(index == s.length()){
            return 1;
        }
        
        if(s.charAt(index)=='0'){
            return 0;
        }
        
        int way1 = helper(s, index+1);
        int way2 = 0;
        if(index < s.length()-1 && Integer.parseInt(s.substring(index, index+2)) <= 26){
            way2 = helper(s, index+2);
        }
        return way1 + way2;
    }
    
Memoization:

public int numDecodings(String s) {
        int N = s.length();
        if(N==1){
            if(s.charAt(0)=='0'){
                return 0;
            }
            else{
                return 1;
            }
        }
        int [] memo = new int[N];
        Arrays.fill(memo, -1);
        return helper(s, 0, memo);
    }
    
    private int helper(String s, int index, int [] memo){
        if(index == s.length()){
            return 1;
        }
        
        if(s.charAt(index)=='0'){
            return 0;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        int way1 = helper(s, index+1, memo);
        int way2 = 0;
        if(index < s.length()-1 && Integer.parseInt(s.substring(index, index+2)) <= 26){
            way2 = helper(s, index+2, memo);
        }
        return memo[index] = way1 + way2;
    }
*/
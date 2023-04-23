class Solution {
    private int MOD = (int) 1e9 + 7;
    
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        long [] memo = new long[n];
        Arrays.fill(memo, -1);
        return (int) helper(0, s, k, memo);    
    }
    
    private long helper(int index, String s, int k, long [] memo){
        if(index == s.length()){
            return 1;
        }
        
        if(s.charAt(index) == '0'){
            return 0;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        long current = 0;
        int currentIndex = index;
        long totalArrays = 0;
        
        while(currentIndex < s.length() && current <= k){
            current *= 10;
            current += s.charAt(currentIndex) - '0';
            
            if(current <= k){
                totalArrays += (helper(currentIndex+1, s, k, memo)) % MOD;
            }
            else{
                break;
            }
            
            currentIndex++;
        }
        
        return memo[index] = totalArrays % MOD;
    }
}
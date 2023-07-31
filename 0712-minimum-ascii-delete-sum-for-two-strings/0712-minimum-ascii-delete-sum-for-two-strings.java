class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        int [][] memo = new int[n1][n2];
        
        for(int i=0;i<n1;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(n1-1, n2-1, s1, s2, memo);
    }
    
    private int helper(int index1, int index2, String s1, String s2, int [][] memo){
        if(index1 == -1 || index2 == -1){
            if(index1 == -1 && index2 == -1){
                return 0;
            }
            return (index1==-1) ? addASCII(s2, index2) : addASCII(s1, index1);
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        int sum = 0;
        
        // Match
        if(s1.charAt(index1) == s2.charAt(index2)){
            sum = 0 + helper(index1-1, index2-1, s1, s2, memo);
        }
        else{
            sum = Math.min((int)s1.charAt(index1) + helper(index1-1, index2, s1, s2, memo), (int)s2.charAt(index2) + helper(index1, index2-1, s1, s2, memo));
        }
        
        return memo[index1][index2] = sum;
    }
    
    private int addASCII(String str, int index){
        int sum = 0;
        
        for(int i=0;i<=index;i++){
            sum += (int) str.charAt(i);
        }
        
        return sum;
    }
}
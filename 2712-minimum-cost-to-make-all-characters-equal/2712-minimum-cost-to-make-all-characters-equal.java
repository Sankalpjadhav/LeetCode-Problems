class Solution {
    public long minimumCost(String s) {
        long minCost = 0;
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) != s.charAt(i-1)){
                minCost += Math.min(i, s.length() - i);
            }
        }
        
        return minCost;
    }
}
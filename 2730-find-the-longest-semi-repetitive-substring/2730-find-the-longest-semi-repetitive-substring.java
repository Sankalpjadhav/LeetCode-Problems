class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1, lastOccurence = -1;
        int longestSubstring = 0;
        
        while(j < n){
            if(s.charAt(j) == s.charAt(j-1)){
                if(lastOccurence != -1){
                    i = lastOccurence;
                }
                lastOccurence = j;
            }
            longestSubstring = Math.max(longestSubstring, j - i);
            j++;
        }
        
        return longestSubstring + 1;
    }
}
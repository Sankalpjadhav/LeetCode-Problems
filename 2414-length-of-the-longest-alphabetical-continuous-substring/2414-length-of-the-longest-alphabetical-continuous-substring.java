class Solution {
    public int longestContinuousSubstring(String s) {
        int count = 1;
        int maxCount = 1;
        int i = 1;
        
        while(i < s.length()){
            if(i > 0){
                int previousChar = (int) s.charAt(i-1);
                int currentChar = (int) s.charAt(i);
                if(previousChar + 1 == currentChar){
                    count++;
                }
                else{
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
            i++;
        }
        
        return maxCount;
    }
}
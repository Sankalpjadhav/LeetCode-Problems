class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        
        int length = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        
        while(right < s.length()){
            char ch = s.charAt(right);
            if(set.contains(ch)){
                while(set.contains(ch)){
                    char ch1 = s.charAt(left);
                    set.remove(ch1);
                    left++;
                }
            }
            
            length = Math.max(length, right - left + 1);
            set.add(ch);
            right++;
        }
        
        return length;
    }
}
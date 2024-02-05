class Solution {
    public int firstUniqChar(String s) {
        int index = -1;
        int [] hash = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hash[ch-'a']++;
        }
        
        for(int i=0; i<s.length(); i++){
            if(hash[s.charAt(i)-'a'] == 1){
                index = i;
                break;
            } 
        }
        
        return index;
    }
}
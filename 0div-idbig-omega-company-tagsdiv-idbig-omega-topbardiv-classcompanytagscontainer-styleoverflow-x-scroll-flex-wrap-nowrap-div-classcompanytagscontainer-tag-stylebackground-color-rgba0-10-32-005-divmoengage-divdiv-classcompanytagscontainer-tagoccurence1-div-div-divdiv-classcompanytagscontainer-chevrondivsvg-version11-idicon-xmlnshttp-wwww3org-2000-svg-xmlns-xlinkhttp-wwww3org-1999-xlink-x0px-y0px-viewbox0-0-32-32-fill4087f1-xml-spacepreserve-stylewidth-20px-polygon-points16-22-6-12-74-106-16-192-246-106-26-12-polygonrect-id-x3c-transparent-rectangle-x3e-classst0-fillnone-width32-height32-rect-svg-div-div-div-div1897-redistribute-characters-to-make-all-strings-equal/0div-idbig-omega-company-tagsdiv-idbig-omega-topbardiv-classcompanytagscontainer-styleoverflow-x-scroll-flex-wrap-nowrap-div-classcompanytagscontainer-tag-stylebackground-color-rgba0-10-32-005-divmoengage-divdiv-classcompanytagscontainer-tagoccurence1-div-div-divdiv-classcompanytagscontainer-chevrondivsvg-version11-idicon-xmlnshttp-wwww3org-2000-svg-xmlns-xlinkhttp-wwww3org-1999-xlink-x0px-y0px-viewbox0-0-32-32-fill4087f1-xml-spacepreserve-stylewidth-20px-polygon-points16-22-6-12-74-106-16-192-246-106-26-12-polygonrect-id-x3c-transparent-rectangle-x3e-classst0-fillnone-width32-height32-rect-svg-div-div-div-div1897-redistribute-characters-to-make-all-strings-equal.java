class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int [] charArray = new int[26];
        
        for(String word: words){
            for(int i=0;i<word.length();i++){
                charArray[word.charAt(i) - 'a']++;
            }
        }
        
        for(int i=0;i<26;i++){
            if(charArray[i] % n != 0){
                return false;
            }
        }
        
        return true;
    }
}
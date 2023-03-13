class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        
        for(int i=left;i<=right;i++){
            if(isVowelString(words[i])){
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isVowelString(String word){
        char ch1 = word.charAt(0);
        char ch2 = word.charAt(word.length()-1);
        
        if((ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') && (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u')){
            return true;
        }
        
        return false;
    }
}
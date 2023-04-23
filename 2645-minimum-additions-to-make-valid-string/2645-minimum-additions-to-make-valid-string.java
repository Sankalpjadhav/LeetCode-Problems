class Solution {
    public int addMinimum(String word) {
        String currentWord = "abc";
        
        while(true){
            if(isValid(word, currentWord)){
                return currentWord.length() - word.length();
            }
            currentWord += "abc";
        }

    }
    
    private boolean isValid(String word, String currentWord){
        int len1 = word.length();
        int len2 = currentWord.length();
        
        int i = 0;
        int j = 0;
        
        while(i<len1 && j<len2){
            if(word.charAt(i) == currentWord.charAt(j)){
                i++;
            }
            j++;
        }
        
        return i==len1;
    }
}
class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int numberOfCapitalLetters = 0;
        
        for(char ch: word.toCharArray()){
            if(Character.isUpperCase(ch)){
                numberOfCapitalLetters++;
            }
        }
        
        if(numberOfCapitalLetters == 0 || numberOfCapitalLetters == n){
            return true;
        }
        
        if(numberOfCapitalLetters == 1){
            if(Character.isUpperCase(word.charAt(0))){
                return true;
            }
        }
        
        return false;
    }
}
class Solution {
    public int maxVowels(String s, int k) {
        int maxNumberOfVowels = 0;
        int i = 0, j = 0;
        int n = s.length();
        int count = 0;
        while(j < n){
            if(isVowel(s.charAt(j))){
                count++;
            }
            if(j - i + 1 < k){
                j++;
            }
            else{
                maxNumberOfVowels = Math.max(maxNumberOfVowels, count);
                if(isVowel(s.charAt(i))){
                    count--;
                }
                i++;
                j++;
            }
        }
        
        return maxNumberOfVowels;
    }
    
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        
        return false;
    }
}
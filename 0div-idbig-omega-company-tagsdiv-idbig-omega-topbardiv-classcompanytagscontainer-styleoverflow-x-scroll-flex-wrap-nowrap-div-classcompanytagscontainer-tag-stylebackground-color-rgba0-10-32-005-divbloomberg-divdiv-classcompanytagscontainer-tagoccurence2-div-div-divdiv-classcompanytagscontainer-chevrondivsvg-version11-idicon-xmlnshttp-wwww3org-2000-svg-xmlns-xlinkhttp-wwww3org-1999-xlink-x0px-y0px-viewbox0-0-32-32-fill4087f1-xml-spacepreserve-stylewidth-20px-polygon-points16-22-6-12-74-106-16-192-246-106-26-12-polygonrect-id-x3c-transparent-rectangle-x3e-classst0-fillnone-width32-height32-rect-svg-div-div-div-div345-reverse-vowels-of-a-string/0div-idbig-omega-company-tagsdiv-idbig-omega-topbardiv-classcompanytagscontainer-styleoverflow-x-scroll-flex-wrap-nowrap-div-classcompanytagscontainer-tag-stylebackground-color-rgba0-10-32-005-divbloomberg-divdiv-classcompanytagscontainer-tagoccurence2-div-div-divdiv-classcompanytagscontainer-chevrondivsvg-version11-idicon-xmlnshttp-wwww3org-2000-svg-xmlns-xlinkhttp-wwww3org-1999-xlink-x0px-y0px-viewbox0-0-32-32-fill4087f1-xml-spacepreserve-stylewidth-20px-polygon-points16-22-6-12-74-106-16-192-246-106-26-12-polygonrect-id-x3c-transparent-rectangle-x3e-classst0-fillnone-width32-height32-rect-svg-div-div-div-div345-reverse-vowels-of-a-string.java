class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        
        char [] charArray = s.toCharArray();
        int left = 0;
        int right = n-1;
        
        while(left < right){
            boolean charA = isVowel(charArray[left]);
            boolean charB = isVowel(charArray[right]);
            
            if(charA && charB){
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
            else if(charA){
                right--;
            }
            else{
                left++;
            }
        }
        
        return new String(charArray);
    }
    
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch =='U'){
            return true;
        }
        return false;
    }
}
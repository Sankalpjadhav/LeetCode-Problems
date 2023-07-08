class Solution {
    public String reverseVowels(String s) {
        char [] array = s.toCharArray();
        
        int left = 0;
        int right = s.length()-1;
        
        while(left < right){
            boolean char1 = isVowel(array[left]);
            boolean char2 = isVowel(array[right]);
                
            if(char1 && char2){    
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++; 
                right--;
            }
            else if(char1 == true){
                right--;
            }
            else{
                left++;
            }
        }
        
        return new String(array);
    }
    
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        
        return false;
    }
}
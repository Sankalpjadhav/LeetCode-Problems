class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;
        char [] str = s.toCharArray();
        
        while(left < right){
            if(str[left] != str[right]){
                if(str[left] < str[right]){
                    str[right] = str[left];
                }
                else{
                    str[left] = str[right];
                }
            }
            left++;
            right--;
        }
        
        return new String(str);
    }
}
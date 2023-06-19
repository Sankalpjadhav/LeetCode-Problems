class Solution {
    public boolean isStrictlyPalindromic(int n) {
        
        for(int i=2;i<n-1;i++){
            if(!checkPalindrome(Integer.toString(n, i))){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean checkPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
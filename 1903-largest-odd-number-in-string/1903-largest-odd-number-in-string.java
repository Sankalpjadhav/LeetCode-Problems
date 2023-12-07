class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int i = n-1;
        
        while(i >= 0){
            int digit = num.charAt(i) - '0';
            if(digit % 2 == 0){
                i--;
            }
            else{
                break;
            }
        }
        
        if(i==-1){
            return "";
        }
        
        return num.substring(0, i+1);
    }
}
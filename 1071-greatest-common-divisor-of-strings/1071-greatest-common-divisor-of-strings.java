class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        
        int lengthOfGCD = gcd(n1, n2);
        return str1.substring(0, lengthOfGCD);
    }
    
    private int gcd(int len1, int len2){
        if(len2 == 0){
            return len1;
        }
        
        return gcd(len2, len1%len2);
    }
}
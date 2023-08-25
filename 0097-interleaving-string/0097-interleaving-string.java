class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        
        if(n3 != n1+n2){
            return false;
        }
        
        return helper(n1-1, n2-1, n3-1, s1, s2, s3);
    }
    
    private boolean helper(int n1, int n2, int n3, String s1, String s2, String s3){
        if(n1 < 0 && n2 < 0 && n3 < 0){
            return true;
        }
        
        if(n1 >= 0 && n3 >=0 && s1.charAt(n1) == s3.charAt(n3) && n2 >= 0 && s2.charAt(n2) == s3.charAt(n3)){
            return helper(n1-1, n2, n3-1, s1, s2, s3) || helper(n1, n2-1, n3-1, s1, s2, s3);
        }
        
        if(n1 >= 0 && n3 >=0 && s1.charAt(n1) == s3.charAt(n3)){
            return helper(n1-1, n2, n3-1, s1, s2, s3);
        }
        
        if(n2 >= 0 && n3 >= 0 && s2.charAt(n2) == s3.charAt(n3)){
            return helper(n1, n2-1, n3-1, s1, s2, s3);
        }
        
        return false;
    }
}
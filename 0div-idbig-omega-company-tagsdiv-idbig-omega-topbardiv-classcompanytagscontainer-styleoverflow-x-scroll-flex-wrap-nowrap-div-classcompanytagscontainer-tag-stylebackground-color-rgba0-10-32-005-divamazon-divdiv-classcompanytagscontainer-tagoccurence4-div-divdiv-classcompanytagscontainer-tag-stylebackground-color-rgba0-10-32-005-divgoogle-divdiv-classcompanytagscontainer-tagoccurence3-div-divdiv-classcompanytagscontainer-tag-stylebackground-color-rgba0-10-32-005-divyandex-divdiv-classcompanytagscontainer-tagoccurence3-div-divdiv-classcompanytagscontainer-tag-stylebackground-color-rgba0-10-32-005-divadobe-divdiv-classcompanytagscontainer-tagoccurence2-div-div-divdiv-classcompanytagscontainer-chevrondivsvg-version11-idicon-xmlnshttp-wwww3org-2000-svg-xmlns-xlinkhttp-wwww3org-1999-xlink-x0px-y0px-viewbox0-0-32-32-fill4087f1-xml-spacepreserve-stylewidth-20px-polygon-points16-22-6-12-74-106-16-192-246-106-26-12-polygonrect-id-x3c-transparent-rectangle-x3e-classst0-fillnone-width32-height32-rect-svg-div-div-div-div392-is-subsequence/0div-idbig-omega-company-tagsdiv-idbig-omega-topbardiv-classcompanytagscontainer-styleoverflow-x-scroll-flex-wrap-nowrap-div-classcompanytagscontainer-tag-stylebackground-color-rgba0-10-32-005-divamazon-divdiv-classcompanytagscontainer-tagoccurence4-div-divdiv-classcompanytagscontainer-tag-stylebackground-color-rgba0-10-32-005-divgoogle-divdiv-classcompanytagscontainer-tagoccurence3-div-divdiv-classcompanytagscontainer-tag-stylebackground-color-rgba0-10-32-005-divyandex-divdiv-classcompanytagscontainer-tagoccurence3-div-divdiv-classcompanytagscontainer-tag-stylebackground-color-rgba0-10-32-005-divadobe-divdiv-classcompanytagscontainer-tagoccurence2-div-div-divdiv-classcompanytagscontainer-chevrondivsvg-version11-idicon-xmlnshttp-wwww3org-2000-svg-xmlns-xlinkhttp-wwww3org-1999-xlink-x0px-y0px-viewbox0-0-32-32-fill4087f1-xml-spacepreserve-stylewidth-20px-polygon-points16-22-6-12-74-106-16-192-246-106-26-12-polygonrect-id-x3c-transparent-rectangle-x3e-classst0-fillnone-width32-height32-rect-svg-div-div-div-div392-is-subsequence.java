class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        if(m == 0){
            return true;
        }
        int n = t.length();
        
        int i = 0, j = 0;
        
        while(j < n){
            while(j < n && t.charAt(j) != s.charAt(i)){
                j++;
            }
            
            if(j == n){
                return false;
            }
            
            i++;
            if(i == m){
                return true;
            }
            
            j++;
        }
        
        return false;
    }
}
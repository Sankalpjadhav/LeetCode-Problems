class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if(s.equals(target)){
            return true;
        }
        
        int n = s.length();
        boolean haveOneS = false;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1' ){
                haveOneS = true;
                break;
            }
        }
        boolean haveOneT = false;
        for(int i=0; i<n; i++){
            if(target.charAt(i) == '1' ){
                haveOneT = true;
                break;
            }
        }
        
        if(haveOneS == false){
            return false;
        }
        
        return haveOneT;
    }
}
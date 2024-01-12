class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length()/2;
        String a =s.substring(0,n);
        String b = s.substring(n);
        int countA=0;
        for(int i=0;i<a.length();i++){
            char ch = a.charAt(i);
            if(check(ch)){
                countA++;
            }
        }
        int countB=0;
        for(int i=0;i<b.length();i++){
            char ch = b.charAt(i);
            if(check(ch)){
                countB++;
            }
        }
        return countA==countB;
    }
    
    public static boolean check(char match){
        if(match == 'a' || match == 'e'|| match == 'i' || match == 'o' || match == 'u' ||
           match == 'A' || match == 'E'|| match == 'I' || match == 'O' || match == 'U'){
                return true;
            }
        return false;
    }
}

/*
var v = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int a = 0, b = 0;
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (v.contains(s.charAt(i))) 
                a +=  1;
            if(v.contains(s.charAt(j)))
                b +=  1;
        }
        return a == b;
*/
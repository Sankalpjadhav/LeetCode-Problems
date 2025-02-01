class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        HashMap<String, Boolean> memo = new HashMap<>();
        return wildcardMatching(m, n, s, p, memo);
    }

    private boolean wildcardMatching(int index1, int index2, String s, String p, HashMap<String, Boolean> memo){
        if(index1 == 0 && index2 == 0) return true;

        if(index1 == 0){
            for(int i=0;i<index2;i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(index2 == 0){
            return false;
        }

        String key = index1 + "_" + index2;

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(s.charAt(index1-1) == p.charAt(index2-1) || p.charAt(index2-1) == '?'){
            boolean result1 = wildcardMatching(index1-1, index2-1, s, p, memo);
            memo.put(key, result1);
            return result1;
        }

        if(p.charAt(index2-1) == '*'){
            boolean result2 = wildcardMatching(index1-1, index2, s, p, memo) || wildcardMatching(index1, index2-1, s, p, memo);
            memo.put(key, result2);
            return result2;
        }

        memo.put(key, false);
        return false;
    }
}

/*
Recursion:

public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        return wildcardMatching(m, n, s, p);
    }

    private boolean wildcardMatching(int index1, int index2, String s, String p){
        if(index1 == 0 && index2 == 0) return true;

        if(index1 == 0){
            for(int i=0;i<index2;i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(index2 == 0){
            return false;
        }

        if(s.charAt(index1-1) == p.charAt(index2-1) || p.charAt(index2-1) == '?'){
            return wildcardMatching(index1-1, index2-1, s, p);
        }

        if(p.charAt(index2-1) == '*'){
            return wildcardMatching(index1-1, index2, s, p) || wildcardMatching(index1, index2-1, s, p);
        }

        return false;
    }
*/
class Solution {
    public int minimumPartition(String s, int k) {
        if(s.length() == 1){
            if(Integer.parseInt(s.charAt(0)+"") <= k){
                return 1;
            }
            return -1;
        }

        int n = s.length();

        long cur = 0;

        int ans = 0;

        for (int i = 0; i < n; ++i) {

            if (cur * 10
                    + Character.getNumericValue(s.charAt(i))
                <= k) {

                cur = cur * 10
                      + Character.getNumericValue(
                          s.charAt(i));
            }
            else {

                if (cur == 0 || cur > k) {

                    return -1;
                }
                else {

                    ans++;

                    cur = Character.getNumericValue(
                        s.charAt(i));
                }
            }
        }

        if (cur > 0 && cur <= k) {
            ans++;
        }

        return ans;
    }
    
}


/*
public int minimumPartition(String s, int k) {
        if(s.length() == 1){
            if(Integer.parseInt(s.charAt(0)+"") <= k){
                return 1;
            }
            return -1;
        }
        
        HashMap<String, Integer> memo = new HashMap<>();
        
        int res = helper(0, s, "", k, memo);
        
        if(res == (int)1e6){
            return -1;
        }
        
        return res;
    }
    
    private int helper(int ind, String s, String str, int k, HashMap<String, Integer> memo){
        if(ind == s.length()){
            return 1;
        }
        
        String e = ind+"-"+str;
        if(memo.containsKey(e)){
            return memo.get(e);
        }
        
        int num = Integer.parseInt(str+s.charAt(ind));
        
        int consider = (int)1e6;
        int notConsider = (int)1e6;
        if(num <= k){
            consider = 0 + helper(ind+1, s, str+s.charAt(ind), k, memo);
        }
        else{
            notConsider = 1 + helper(ind+1, s, s.charAt(ind)+"", k, memo);
        }
        
        int res = Math.min(consider, notConsider);
        memo.put(e, res);
        return res;
    }
*/
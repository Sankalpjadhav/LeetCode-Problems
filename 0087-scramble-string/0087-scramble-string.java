class Solution {
    HashMap<String, Boolean> map = new HashMap<>(); 
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        
        if(s1.length()==0 && s2.length()==0){
            return true;
        }
        
        
        return solve(s1, s2);
    }
    
    public boolean solve(String a, String b){
        if(a.equals(b)) return true;
        if(a.length()<=1)   return false;
        String key = a+" "+b;
        // Memoization
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int n =a.length(); // n=b.length();
        boolean flag = false;
        
        for(int i=1;i<=n-1;i++){
            // CASE1 : Swapping taking place
            if(solve(a.substring(0,i),b.substring(n-i)) == true && solve(a.substring(i),b.substring(0,n-i)) == true){
                flag = true;
                break;
            }
            
            // CASE2 : No Swapping taking place
            if(solve(a.substring(0,i),b.substring(0,i)) == true && solve(a.substring(i),b.substring(i)) == true){
                flag=true;
                break;
            }
            
            
        }
        map.put(key,flag);
        return flag;
    }
}

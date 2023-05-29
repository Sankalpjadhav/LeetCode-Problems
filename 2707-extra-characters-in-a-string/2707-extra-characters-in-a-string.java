class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        
        for(String str: dictionary){
            set.add(str);
        }
        
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        
        return helper(0, s, set, n, memo);
    }
    
    private int helper(int index, String s, Set<String> set, int n, int [] memo){
        if(index == n){
            return 0;
        }
        
        if(set.contains(s.substring(index))){
            return 0;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        int min = n - index;
        
        for(int i=index+1;i<=n;i++){ // <=n bcoz we are using substring(index, i) here i in not inclusive so we need to go till 'n'
            int count = set.contains(s.substring(index, i)) ? 0 : i - index;
            count += helper(i, s, set, n, memo);
            min = Math.min(min, count);
        }
        
        return memo[index] = min;
    }
}
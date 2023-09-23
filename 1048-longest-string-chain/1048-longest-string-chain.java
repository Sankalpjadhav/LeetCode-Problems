class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        
        int [] dp = new int[n];
        //Arrays.fill(dp, 1);
        int maxi = 1;
        for(int ind=0;ind<n;ind++){
            dp[ind] = 1;
            for(int prev_ind=0;prev_ind<ind;prev_ind++){
                if(compare(words[ind], words[prev_ind]) && 1+dp[prev_ind] > dp[ind]){
                    dp[ind] = 1+dp[prev_ind];
                }
            }
            maxi = Math.max(dp[ind], maxi);
        }
        
        return maxi;
    }
   
    private boolean compare(String s1, String s2){
        if(s1.length()!=s2.length()+1) return false;
        int first = 0;
        int second = 0;
        
        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        
        if(first==s1.length() && second==s2.length()){
            return true;
        }
        return false;
    }
}
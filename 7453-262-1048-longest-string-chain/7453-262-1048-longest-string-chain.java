class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a,b)->a.length()-b.length()); // Sort words based on length
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for(int index=1;index<n;index++){
            for(int prevIndex=0;prevIndex<index;prevIndex++){
                if(compare(words[index], words[prevIndex]) && dp[index] < dp[prevIndex] + 1){
                    dp[index] = dp[prevIndex] + 1;
                }
            }
            maxi = Math.max(maxi, dp[index]);
        }

        return maxi;
    }

    private boolean compare(String a, String b){
        if(a.length() != b.length()+1) return false;

        int i = 0, j = 0;

        while(i < a.length()){
            if(j < b.length() && a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }

        if(i == a.length() && j == b.length()){
            return true;
        }

        return false;
    }
}
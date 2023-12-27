class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int [][] memo = new int[n][27];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return minTimeToMakeRopeColorful(n-1, colors, neededTime, '{', memo);
    }
    
    private int minTimeToMakeRopeColorful(int index, String colors, int [] neededTime, char prevColor, int[][] memo){
        if(index == 0){
            if(colors.charAt(index) == prevColor){
                return neededTime[index];
            }
            return 0;
        }
        
        if(memo[index][prevColor - 'a'] != -1){
            return memo[index][prevColor - 'a'];
        }
        
        int removeBallon = neededTime[index] + minTimeToMakeRopeColorful(index-1, colors, neededTime, prevColor, memo);
        int doNotRemoveBallon = (int)1e9;
        if(colors.charAt(index) != prevColor){
            doNotRemoveBallon = 0 + minTimeToMakeRopeColorful(index-1, colors, neededTime, colors.charAt(index), memo);
        }
        return memo[index][prevColor - 'a'] = Math.min(removeBallon, doNotRemoveBallon);
    }
}
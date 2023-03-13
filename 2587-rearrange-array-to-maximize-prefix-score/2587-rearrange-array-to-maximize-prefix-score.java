class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
         
        long prefixMaxScore = 0;
        int ans = 0;
        
        for(int i=nums.length-1;i>=0;i--){
            prefixMaxScore += nums[i];
            if(prefixMaxScore > 0) ans++;
            else break;
        }
        
        return ans;
    }
}
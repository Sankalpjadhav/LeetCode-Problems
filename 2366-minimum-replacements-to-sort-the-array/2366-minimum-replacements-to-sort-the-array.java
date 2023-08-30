class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int prev = nums[n-1];
        for(int i=n-2;i>=0;i--){
            int numberOfSplits = nums[i] / prev;
            if(nums[i] % prev != 0){
                numberOfSplits++;
            }
            
            if(nums[i] % prev != 0){
                prev = nums[i] / numberOfSplits;
            }
            
            ans += numberOfSplits-1;
        }
        
        return ans;
    }
}
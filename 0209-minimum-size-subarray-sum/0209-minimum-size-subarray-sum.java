class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        while(right < n){
            sum += nums[right];
            
            while(sum >= target){
                result = Math.min(right-left+1, result);
                sum-=nums[left];
                left++;
            }
            
            right++;
        }
        
        return result==Integer.MAX_VALUE?0:result;
    }
}
class Solution {
    public int findNonMinOrMax(int[] nums) {
        int MIN = 101;
        int MAX = -1;
        
        for(int i=0;i<nums.length;i++){
            MIN = Math.min(MIN, nums[i]);
            MAX = Math.max(MAX, nums[i]);
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > MIN && nums[i] < MAX){
                return nums[i];
            }
        }
        
        return -1;
    }
}
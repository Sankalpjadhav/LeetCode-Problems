class Solution {
    public int countElements(int[] nums) {
        int n = nums.length;
        
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            MAX = Math.max(MAX, nums[i]);
            MIN = Math.min(MIN, nums[i]);
        }
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            if(nums[i] > MIN && nums[i] < MAX){
                count++;
            }
        }
        
        return count;
    }
}
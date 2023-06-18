class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        
        for(int i=1;i<n;i++){
            min = Math.min(min, nums[i] - nums[i-1]);
        }
        
        return min;
    }
}
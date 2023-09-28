class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int i = 0;
        int right = nums.length-1;
        
        while(i < nums.length){
            if(nums[i] % 2 == 0){
                swap(left, i, nums);
                left++;
            }
            else{
                swap(left, i, nums);
                right--;
            }
            
            i++;
        }
        
        return nums;
        
    }
    
    private void swap(int i, int j, int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
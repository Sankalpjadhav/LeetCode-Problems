class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return;
        }
        
        int index = 0;
        for(int i=0;i<n;i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        
        for(int j=index;j<n;j++){
            nums[j] = 0;
        }
        
    }
}
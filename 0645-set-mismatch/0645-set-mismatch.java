class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicateNumber = -1;
        int missingNumber = -1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1] < 0){
                duplicateNumber = Math.abs(nums[i]);
            }
            else{
                nums[Math.abs(nums[i])-1] *= -1;  
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                missingNumber = i+1;
                break;
            }
        }
        
        return new int[]{duplicateNumber, missingNumber};
    }
}
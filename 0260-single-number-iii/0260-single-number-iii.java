class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xy = 0;
        
        for(int i=0;i<n;i++){
            xy ^= nums[i];
        }
        
        int diff = xy & -xy; // It will find the rightmost set bit
        
        int num1 = 0;
        int num2 = 0;
        
        for(int i=0;i<n;i++){
            if((diff & nums[i]) == 0){
                num1 ^= nums[i];
            }
            else{
                num2 ^= nums[i];
            }
        }
        
        return new int[]{num1, num2};
        
    }
}
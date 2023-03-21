class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long countOfZeroSubarrays = 0;
        int i = 0, j = 0;
        
        while(j < nums.length){
            if(nums[j] == 0){
                countOfZeroSubarrays += j - i + 1;
            }
            else{
                i = j + 1;
            }
            j++;
        }
        
        return countOfZeroSubarrays;
        
        
    }
}
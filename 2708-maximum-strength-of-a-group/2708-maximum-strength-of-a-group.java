class Solution {
    public long maxStrength(int[] nums) {
        long result = 1;
        int n = nums.length;
        int numberOfNegativeNumbers = 0;
        int numberOfZeros = 0;
        int maxNegativeNumber = -10;
        int largestNumber = -10;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                result *= nums[i];
                if(nums[i] < 0){
                    numberOfNegativeNumbers++;
                    maxNegativeNumber = Math.max(maxNegativeNumber, nums[i]);
                }
            }
            else{
                numberOfZeros++;
            }
            
            largestNumber = Math.max(largestNumber, nums[i]);
        }
        
        if(largestNumber == 0 && numberOfNegativeNumbers < 2){
            return 0;
        }
        
        if(largestNumber < 0 && numberOfNegativeNumbers == 1){
            return maxNegativeNumber;
        }
        
        if(numberOfZeros == n){
            return 0;
        }
        
        if(result < 0){
            result /= maxNegativeNumber;
        }
        
        return result;
    }
}
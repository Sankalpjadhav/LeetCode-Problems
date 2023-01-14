class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = (int)1e9;
        
        while(low <= high){
            int divisor = low + (high - low)/2;
            
            if(calculateSum(nums, divisor) > threshold){
                low = divisor + 1;
            }
            else{
                high = divisor - 1;
            }
        }
        
        return low;
    }
    
    private long calculateSum(int [] nums, int divisor){
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += (int) Math.ceil((double)nums[i]/divisor);
        }
        
        return sum;
    }
}
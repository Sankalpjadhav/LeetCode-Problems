class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int low = 1;
        int high = (int)1e9;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isDivisible(mid, nums) > threshold){
                low = mid + 1;
            }
            else{
                high = mid - 1; 
            }
        }

        return low;
    }

    private int isDivisible(int divisor, int [] nums){
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum += (int) Math.ceil((double)nums[i]/divisor);
        }

        return sum;
    }
}
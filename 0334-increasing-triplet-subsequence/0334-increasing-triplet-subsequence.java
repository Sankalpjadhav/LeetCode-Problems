class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(num < smallest){
                //secondSmallest = smallest;
                smallest = num;
            }
            else if(num < secondSmallest && num != smallest){
                secondSmallest = num;
            }
            else if(num > secondSmallest){
                return true;
            }
        }
        
        return false;
    }
}
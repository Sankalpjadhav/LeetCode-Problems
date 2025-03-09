class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[] {-1, -1};
        int lowerBound = binarySearch(nums, target, true);
        if(lowerBound == -1){
            return result;
        }
        int higherBound = binarySearch(nums, target, false);
        
        result[0] = lowerBound;
        result[1] = higherBound;
        return result;
    }

    private int binarySearch(int [] nums, int element, boolean flag){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int lowerBound = -1;
        int higherBound = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(flag){
                // Need to find the lowerBound
                if(element == nums[mid]){
                    lowerBound = mid;
                    high = mid - 1;
                }
                else if(element < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                // Need to find the higherBound
                if(element == nums[mid]){
                    higherBound = mid;
                    low = mid + 1;
                }
                else if(element > nums[mid]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        
        if(flag){
            return lowerBound;
        }
        
        return higherBound;
    }
}
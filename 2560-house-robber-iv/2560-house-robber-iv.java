class Solution {

    public int minCapability(int[] nums, int k) {
        int low = 1;
        int high = (int)1e9+1;
        int result = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(good(mid, nums, k)){
                result = Math.min(result, mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean good(int mid, int [] nums, int k){
        int i = 0;
        int j = nums.length;
        
        while(i < j){
            if(nums[i] <= mid){
                k--;
                i+=2;
            }
            else{
                i+=1;
            }
            
            if(k == 0){
                return true;
            }
        }
        
        return false;
    }
   
}
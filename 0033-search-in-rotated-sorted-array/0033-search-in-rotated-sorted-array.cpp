class Solution {
public:
    int search(vector<int>& nums, int target) {
         int left = 0;
        int right = nums.size()-1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] >= nums[left]){ // True if strictly increasing
                if(target <= nums[mid] && target >= nums[left]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{  // non-uniform increasing or decreasing
                if(target >= nums[mid] && target <= nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
};
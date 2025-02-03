class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[left] <= nums[mid]){
                // Left is sorted
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                // Right side is sorted
                if(nums[right] >= target && target >= nums[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

/*
Brute force approach: O(n)

public int search(int[] nums, int target) {
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        /*
            index:
            0 1 2 3 4 5 6 7 8  9 10
            nums:    
            1 1 2 3 3 4 4 8 8
            nums:
            1 1 2 2 3 3 4 9 9 10 10


            Lets say mid = even
                - If element at mid + 1 == element at mid
                    - The element that appears exactly once lies to the right side
                - If element at mid - 1 == element at mid
                    - The element that appears exactly once lies to the left side

            Lets say mid = odd
                - If element at mid != element at mid + 1
                    - The element that appears exactly once lies to the right side
                - If element at mid != element at mid - 1
                    - The element that appears exacly once lies to the ledt side
                    
            Once caluclated mid, check if mid - 1 and mid + 1 are not same, then directly return that element
        */
        int low = 0;
        int high = n-2;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid % 2 == 0){
                // even
                if(nums[mid] == nums[mid+1]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            else{
                // odd
                if(nums[mid] == nums[mid+1]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
        }

        return nums[low];

    }
}

/*
Brute force approach:  O(n)

public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i=0;i<n;i++){
            result = result ^ nums[i];
        }

        return result;
    }
*/
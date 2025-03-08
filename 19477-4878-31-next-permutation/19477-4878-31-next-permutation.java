class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        /*
            Find the Pivot:
            Traverse the array from the end to find the first element nums[i] such that nums[i] < nums[i + 1]. This element is the pivot.
            If no such element exists, the array is sorted in descending order. Reverse the array to get the smallest permutation.
            
            Find the Successor:
            Traverse from the end to find the smallest element greater than the pivot (nums[i]) and swap them.
            
            Reverse the Suffix:
            Reverse the elements from index i + 1 to the end of the array to make it the next lexicographical permutation.
        */

        int pivotIndex = n-2;
        while(pivotIndex >=0 && nums[pivotIndex] >= nums[pivotIndex+1]){
            pivotIndex--;
        }

        if(pivotIndex >= 0){
            // Find the Successor
            int index2 = n-1;
            while(pivotIndex < index2 && nums[index2] <= nums[pivotIndex]){
                index2--;
            }

            int temp = nums[pivotIndex];
            nums[pivotIndex] = nums[index2];
            nums[index2] = temp;
        }
        
        // Reverse right half of pivotIndex
        int low = pivotIndex+1;
        int high = n-1;

        while(low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    
}

/*

Brute force:
            Brute force approach:
            1. Generate all the permuations of the given array
            2. Sort the permutations in lexicographical order
            3. If nums appears at index i, then the array at i+1 index is the nums we want to return.

public void nextPermutation(int[] nums) {
        int n = nums.length;
        List<int[]> permutations = new ArrayList<>();

        // Generate all permutations
        generatePermutations(0, nums, permutations);

        // Sort the permutations lexicographically
        permutations.sort((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return Integer.compare(a[i], b[i]);
                }
            }
            return 0;
        });

        // Find the current permutation and determine the next one
        int index = -1;
        for (int i = 0; i < permutations.size(); i++) {
            if (Arrays.equals(permutations.get(i), nums)) {
                index = i + 1 < permutations.size() ? i + 1 : 0;
                break;
            }
        }

        // Update nums with the next permutation
        for (int i = 0; i < n; i++) {
            nums[i] = permutations.get(index)[i];
        }
    }

    private void generatePermutations(int index, int[] nums, List<int[]> permutations) {
        if (index == nums.length) {
            // Deep copy the array to avoid reference issues
            permutations.add(Arrays.copyOf(nums, nums.length));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            generatePermutations(index + 1, nums, permutations);
            swap(nums, index, i); // Backtrack
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
*/
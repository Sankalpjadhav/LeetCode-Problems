class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        /*
            1. Ignore negative nums and 0
            2. For every num go to that index-1 and change the nums[index] to -nums[index]
               This will represent that index+1 element is present in the array
            3. Loop through the nums and check if any num is +ve, that means index+1 is the missing number. 
        */

        // Step 1
        for(int i=0;i<n;i++){
            if(nums[i] <= 0){
                nums[i] = n+1;
            }
        }

        // Step 2
        for(int i=0;i<n;i++){
            int k = Math.abs(nums[i]);

            if(k > n) continue;

            k--;

            nums[k] = Math.abs(nums[k]) * -1;
        }

        // Step 3
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }

        return n+1;

    }
}

/*
Brute force: TC: O(2N), SC: O(N)
public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            if(num <= 0){
                continue;
            }
            set.add(num);
        }

        for(int i=1;i<=n+1;i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }
*/
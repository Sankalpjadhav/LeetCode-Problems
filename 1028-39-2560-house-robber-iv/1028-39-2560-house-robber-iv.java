class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        if(n < k){
            return 0;
        }

        int maxCapability = 0;

        for(int num: nums){
            maxCapability = Math.max(num, maxCapability);
        }

        int low = 1;
        int high = maxCapability;
        int result = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canRobWithCapability(mid, k, nums)){
                result = Math.min(result, mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canRobWithCapability(int capability, int k, int [] nums){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            if(nums[low] <= capability){
                low += 2;
                k--;
            }
            else{
                low +=1;
            }

            if(k == 0){
                return true;
            }
        }

        return false;
    }


}

/*
Brute force approach:

public int minCapability(int[] nums, int k) {
        int n = nums.length;
        if(n < k){
            return 0;
        }

        List<List<Integer>> subsets = new ArrayList<>();

        generateAllTheSubsets(0, n, nums, subsets, new ArrayList<>(), k);
        int minCapability = Integer.MAX_VALUE;
        for(List<Integer> subset: subsets){
            int maxValue = 0;
            for(int value: subset){
                maxValue = Math.max(maxValue, value);
            }
            minCapability = Math.min(maxValue, minCapability);
        }

        return minCapability;
    }

    private void generateAllTheSubsets(int index, int n, int [] nums, List<List<Integer>> subsets, List<Integer> subset, int k){
        if(index >= n){
            if(subset.size() >= k){
                subsets.add(new ArrayList<>(subset));
            }
            return;
        }

        generateAllTheSubsets(index+1, n, nums, subsets, subset, k);

        subset.add(nums[index]);
        generateAllTheSubsets(index+2, n, nums, subsets, subset, k);
        subset.remove(subset.size()-1);
    }

*/
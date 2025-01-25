class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Approach is simple, at every index we have two options i.e. to pick or not pick.
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int n = nums.length;
        findSubsets(0, n, nums, subset, result);

        return result;
    }

    private void findSubsets(int index, int n, int [] nums, List<Integer> subset, List<List<Integer>> result){
        if(index == n){
            result.add(new ArrayList<>(subset));
            return;
        }

        // Not pick the element at the current index
        findSubsets(index+1, n, nums, subset, result);

        // Pick the element at the current index
        subset.add(nums[index]);
        findSubsets(index+1, n, nums, subset, result);
        subset.remove(subset.size()-1);
    }
}
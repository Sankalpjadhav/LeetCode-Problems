class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        findSubset(0, n, nums, subset, result); 

        return result;
    }

    private void findSubset(int index, int n, int [] nums, List<Integer> subset, List<List<Integer>> result){
        result.add(new ArrayList<>(subset));

        for(int i=index;i<n;i++){
            if(i!=index && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            findSubset(i+1, n, nums, subset, result);
            subset.remove(subset.size()-1);
        }
    }
}
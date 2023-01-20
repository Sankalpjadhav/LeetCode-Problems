class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        helper(0, nums, result, new ArrayList<>());
        return new ArrayList<>(result);
    }
    
    private void helper(int index, int [] nums, Set<List<Integer>> result, List<Integer> tempList){
        if(index == nums.length){
            if(tempList.size() >= 2){
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        
        // Include
        if(tempList.isEmpty() || tempList.get(tempList.size()-1) <= nums[index]){
            tempList.add(nums[index]);
            helper(index+1, nums, result, tempList);
            tempList.remove(tempList.size()-1);
        }
        // Exclude
        helper(index+1, nums, result, tempList);
    }
}
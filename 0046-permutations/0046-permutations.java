class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void getPermutations(int[] nums, int index,  ArrayList<Integer> permutation){
        if(index==nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!permutation.contains(nums[i])){
                permutation.add(nums[i]);
                getPermutations(nums, index+1, permutation);
                permutation.remove(permutation.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        getPermutations(nums, 0,  new ArrayList<Integer>());
        return result;
    }
}
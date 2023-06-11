class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int numberOfELementsToRemove = 0;
        int n = nums.length;
        int max = 0;
        
        for(int i=1;i<n && numberOfELementsToRemove <= 1;i++){
             if (nums[i - 1] >= nums[i]) {
                numberOfELementsToRemove++;
                if (i > 1 && nums[i - 2] >= nums[i]){
                    nums[i] = nums[i - 1];
                }
            }
        }
        
        return numberOfELementsToRemove <= 1;
    }
}
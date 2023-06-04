class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int numberOfOperations = 0;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                int j = i;
                while(j>0){
                    numberOfOperations++;
                    swap(nums, j, j-1);
                    j--;
                }
                break;
            }
        }
        
        for(int j=1;j<n;j++){
            if(nums[j] == n){
                int k = j;
                while(k<n-1){
                    numberOfOperations++;
                    swap(nums, k, k+1);
                    k++;
                }
                break;
            }
        }
        
        return numberOfOperations;
    }
    
    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
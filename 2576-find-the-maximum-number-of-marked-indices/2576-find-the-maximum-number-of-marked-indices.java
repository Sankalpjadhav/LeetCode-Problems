class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        int i = 0, j = n/2;
        Arrays.sort(nums);
        int markedIndices = 0;
        while(i < n/2 && j < n){
            if((long)nums[i]*2 <= nums[j]){
                markedIndices += 2;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        
        return markedIndices;
    }
}
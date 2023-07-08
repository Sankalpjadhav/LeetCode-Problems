class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxConsecutiveOnes = 0;
        int i = -1, j = 0;
        int n = nums.length, count = 0;
        
        while(j < n){
            if(nums[j] == 0){
                count++;
            }
            
            while(count > k){
                i++;
                if(nums[i] == 0){
                    count--;
                }
            }
            
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, j - i);
            j++;
        }
        
        return maxConsecutiveOnes;
    }
}
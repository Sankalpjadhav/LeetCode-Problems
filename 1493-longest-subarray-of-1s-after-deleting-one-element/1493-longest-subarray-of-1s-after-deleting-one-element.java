class Solution {
    public int longestSubarray(int[] nums) {
        int maxConsecutiveOnes = 0;
        int i = 0, j = 0;
        int n = nums.length;
        int countOfZeros = 0;
        while(j < n){
            if(nums[j] == 0){
                countOfZeros++;
            }
            if(countOfZeros > 1){
                while(nums[i] != 0){
                    i++;
                }
                i++;
                countOfZeros--;
            }
            
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, j - i);
            j++;
        }
        
        return maxConsecutiveOnes;
    }
}
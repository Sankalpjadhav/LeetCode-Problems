class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int numberOfZeros = 0;
        int ans = 0;
        int j = 0, i = 0;
        while(j < n){
            if(nums[j] == 0){
                numberOfZeros++;
            }
            if(numberOfZeros > 1){
                while(nums[i++]!=0){
                    //System.out.println("i -> "+i);
                }
                numberOfZeros--;
            }
            ans = Math.max(ans, j-i);
            j++;
        }
        
        return ans;
    }
}
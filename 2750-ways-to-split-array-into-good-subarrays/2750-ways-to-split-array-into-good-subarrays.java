class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        int currentCountOfConsecutiveZero = 0;
        int oneCount = 0;
        long ans = 0;
        int MOD = (int) 1e9 + 7;
        
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                currentCountOfConsecutiveZero++;
            }
            else{
                oneCount++;
                if(oneCount == 1){
                    ans = 1;
                }
                else{
                    ans = (ans * (currentCountOfConsecutiveZero + 1)) % MOD;
                }
                currentCountOfConsecutiveZero = 0;
            }
        }
        
        return (int) ans % MOD;
    }
}
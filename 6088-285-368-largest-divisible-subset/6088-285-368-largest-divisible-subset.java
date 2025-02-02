class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int [] prevIndexes = new int[n];
        int [] dp = new int[n];
        Arrays.fill(dp, 1); // Every element is divisible by itself
        int maxi = 1;
        int lastIndex = 0;
        for(int index=1;index<n;index++){
            prevIndexes[index] = index;
            for(int prevIndex=0;prevIndex<index;prevIndex++){
                if(nums[index] % nums[prevIndex] == 0 && dp[index] < dp[prevIndex] + 1){
                    dp[index] = dp[prevIndex] + 1;
                    prevIndexes[index] = prevIndex;
                }
            }
            if(dp[index] > maxi){
                maxi = dp[index];
                lastIndex = index;
            }
        }
        List<Integer> result = new ArrayList<>();
        while(prevIndexes[lastIndex] != lastIndex){
            result.add(0, nums[lastIndex]);
            lastIndex = prevIndexes[lastIndex];
        }

        result.add(0, nums[lastIndex]);
        return result;
    }
}
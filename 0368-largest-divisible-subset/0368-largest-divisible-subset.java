class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        int [] hash = new int[n];
        int maxi = 1; int lastIndex = 0;
        for(int ind=0;ind<n;ind++){
            hash[ind] = ind;
            for(int prev_ind=0;prev_ind<ind;prev_ind++){
                if(nums[ind] % nums[prev_ind] == 0 && 1+dp[prev_ind] > dp[ind]){
                    dp[ind] = 1 + dp[prev_ind];
                    hash[ind] = prev_ind;
                }
            }
            if(maxi < dp[ind]){
                maxi = dp[ind];
                lastIndex = ind;
            }
        }
        
        List<Integer> largestDivisibleSubset = new ArrayList<>();
        while(hash[lastIndex]!=lastIndex){
            largestDivisibleSubset.add(0, nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        largestDivisibleSubset.add(0, nums[lastIndex]);
        return largestDivisibleSubset;
    }
}
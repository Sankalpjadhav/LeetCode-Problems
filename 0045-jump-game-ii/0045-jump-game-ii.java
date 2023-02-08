class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(0, n, nums, memo);
    }
    
    private int helper(int index, int n, int [] nums, int [] memo){
        if(index == n-1){
            return 0;
        }
        
        if(memo[index]!=-1){
            return memo[index];
        }
        
        int minNumberOfJumps = (int)1e9;
        
        for(int i=1;i<=nums[index];i++){
            if(index+i >= n) break;
            minNumberOfJumps = Math.min(minNumberOfJumps, 1 + helper(index+i, n, nums, memo)); 
        }
        
        return memo[index] = minNumberOfJumps;
    }
}
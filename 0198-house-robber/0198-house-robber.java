class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        return robHouses(0, nums, n, memo);
    }
    
    private int robHouses(int index, int [] nums, int n, int [] memo){
        if(index == n-1){
            return nums[index];
        }
        
        if(memo[index]!=-1){
            return memo[index];
        }
        
        int robCurrentHouse = nums[index];
        
        if(index+2 < n){
            robCurrentHouse += robHouses(index+2, nums, n, memo);
        }
        int skipCurrentHouse = 0 + robHouses(index+1, nums, n, memo);
        
        return memo[index] = Math.max(robCurrentHouse, skipCurrentHouse);
    }
}
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int [][] memo = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return Math.max(helper(0, nums, true, memo), helper(0, nums, false, memo));
    }

    private int helper(int index, int [] nums, boolean flag, int [][] memo){
        if(index == nums.length-1){
            return 1;
        }

        if(flag == true){
            if(memo[index][1]!=-1){
                return memo[index][1];
            }
        }
        else{
            if(memo[index][0]!=-1){
                return memo[index][0];
            }
        }

        int ans = 0;
        if(flag){
            // we want positive
            if(nums[index] < nums[index+1]){
                // we take this into consideration
                ans = Math.max(ans, 1+helper(index+1, nums, false, memo));
            }
            else{
                // we wont take it
                ans = Math.max(ans, helper(index+1, nums, true, memo));
            }

        }
        else{
            // we want negative
            if(nums[index] > nums[index+1]){
                // we take this into consideration
                ans = Math.max(ans, 1+helper(index+1, nums, true, memo));
            }
            else{
                // we wont take it
                ans = Math.max(ans, helper(index+1, nums, false, memo));
            }
        }

        if(flag){
            return memo[index][1] = ans;
        }
        return memo[index][0] = ans;
    }
}


/*
RECURSION: Passed

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        
        return Math.max(helper(0, nums, true), helper(0, nums, false));
    }

    private int helper(int index, int [] nums, boolean flag){
        if(index == nums.length-1){
            return 1;
        }

        int ans = 0;
        if(flag){
            // we want positive
            if(nums[index] < nums[index+1]){
                // we take this into consideration
                ans = Math.max(ans, 1+helper(index+1, nums, false));
            }
            else{
                // we wont take it
                ans = Math.max(ans, helper(index+1, nums, true));
            }

        }
        else{
            // we want negative
            if(nums[index] > nums[index+1]){
                // we take this into consideration
                ans = Math.max(ans, 1+helper(index+1, nums, true));
            }
            else{
                // we wont take it
                ans = Math.max(ans, helper(index+1, nums, false));
            }
        }

        return ans;
    }

*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int [] memo1 = new int[n];
        Arrays.fill(memo1, -1);
        int [] memo2 = new int[n];
        Arrays.fill(memo2, -1);
        return Math.max(letsRob(0, n-1, memo1, nums), letsRob(1, n, memo2, nums));
    }

    private int letsRob(int index, int n, int [] memo, int [] nums){
        if(index == n-1){
            return nums[index];
        }
        if(index == n){
            return 0;
        }

        if(memo[index]!=-1) return memo[index];

        int notRobCurrentHouse = 0 + letsRob(index+1, n, memo, nums);
        int robCurrentHouse = nums[index] + letsRob(index+2, n, memo, nums);

        return memo[index] = Math.max(notRobCurrentHouse, robCurrentHouse);
    }
}

/*
Recursion: TC: O(2^n + 2^n), SC: O(2n)

public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(letsRob(0, n-1, nums), letsRob(1, n, nums));
    }

    private int letsRob(int index, int n, int [] nums){
        if(index == n-1){
            return nums[index];
        }
        if(index == n){
            return 0;
        }

        int notRobCurrentHouse = 0 + letsRob(index+1, n, nums);
        int robCurrentHouse = nums[index] + letsRob(index+2, n, nums);

        return Math.max(notRobCurrentHouse, robCurrentHouse);
    }
*/
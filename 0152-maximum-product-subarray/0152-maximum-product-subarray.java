class Solution {
    public int maxProduct(int[] nums) {
        HashMap<String, Integer> memo = new HashMap<>();
        return helper(0, nums, 1, memo);
    }

    private int helper(int index, int [] nums, int product, HashMap<String, Integer> memo){
        if(index == nums.length){
            return product;
        }

        String str = index+"-"+product;
        if(memo.containsKey(str)){
            return memo.get(str);
        }

        int include = helper(index+1, nums, product*nums[index], memo);
        int notInclude = helper(index+1, nums, nums[index], memo);
        if(index == 0){
            product = nums[0];
        }
        int ans = Math.max(product, Math.max(include, notInclude));
        memo.put(str, ans);
        return ans;
    }
}

/*

RECURSION: 182 / 188 testcases passed (TLE)


    public int maxProduct(int[] nums) {
        return helper(0, nums, 1);
    }

    private int helper(int index, int [] nums, int product){
        if(index == nums.length){
            return product;
        }

        int include = helper(index+1, nums, product*nums[index]);
        int notInclude = helper(index+1, nums, nums[index]);
        if(index == 0){
            product = nums[0];
        }
        return Math.max(product, Math.max(include, notInclude));
    }

*/
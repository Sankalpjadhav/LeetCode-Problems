class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        // Here we will be using kadanes algorithm to find the max and min aubarray sum
        // then we will return the maximum of both calculated max and abs(min) subarray

        int maxSumSubarray = 0;
        int minSumSubarray = 0;
        int sum = 0;
        for(int num: nums){
            sum += num;
            if(maxSumSubarray < sum){
                maxSumSubarray = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }

        sum = 0;

        for(int num: nums){
            sum += num;
            if(minSumSubarray > sum){
                minSumSubarray = sum;
            }
            if(sum > 0){
                sum = 0;
            }
        }

        return Math.max(maxSumSubarray, Math.abs(minSumSubarray));
       
    }
}

/*
Brute force: Generate all possible subarrays and return the maxAbsSum

public int maxAbsoluteSum(int[] nums) {
        int maxAbsSum = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                maxAbsSum = Math.max(maxAbsSum, Math.abs(sum));
            }
        }

        return maxAbsSum;
    }
*/
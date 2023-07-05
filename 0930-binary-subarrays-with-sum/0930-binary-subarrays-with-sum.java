class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
		return helper(A, S) - helper(A, S - 1);
	}

	private int helper(int[] nums, int limit) {
		int res = 0;
		int sum = 0;
		int n = nums.length;
		int start = 0;
		int end = 0;
		while (end < n) {
			sum += nums[end++];
			
			while (start < end && sum > limit) {
				sum -= nums[start];
				start++;
			}
			res += end - start + 1;
		}
		return res;
	}
}
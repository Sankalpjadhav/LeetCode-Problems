class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] numCostPair = new int[n][2];
        for(int i = 0; i<n; i++) {
            numCostPair[i][0] = nums[i];
            numCostPair[i][1] = cost[i];
        }
        Arrays.sort(numCostPair, (a, b) -> a[0] - b[0]);
        // allCost will be the length of the array with frequencies included for each number.
        long allCost = 0;
        for(int c: cost) {
            allCost += c;
        }
        // median index should be
        long median = (allCost + allCost%2)/2;
        int j = 0;
        //finding the median index in the num-cost pair array.
        while(median > 0 && j < n) {
            median -= numCostPair[j][1];
            j++;
        }
        //found the median index.
        int index = j-1;
        //finding the answer for median index
        long ans = 0;
        for(int i = 0; i<n; i++) {
            ans += (long)numCostPair[i][1]*Math.abs(numCostPair[i][0]-numCostPair[index][0]);
        }
        return ans;
    }
}
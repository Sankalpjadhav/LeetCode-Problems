class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maximumAverageSum = -1e9;
        int n = nums.length;
        int i = 0, j = 0;
        int sum = 0;
        while(j < n){
            sum += nums[j];
            if(j - i + 1 < k){
                j++;
            }
            else{
                maximumAverageSum = Math.max(maximumAverageSum, (double) sum / k);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        
        return maximumAverageSum;
        
    }
}
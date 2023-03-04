class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int i = 0;
        boolean minEleFound = false, maxEleFound = false;
        long countSubarrays = 0;
        int minIndex = 0, maxIndex = 0;
        for(int j=0;j<n;j++){
            int num = nums[j];
            
            if(num < minK || num > maxK){
                minEleFound = false;
                maxEleFound = false;
                i = j+1;
            }
            
            if(num == minK){
                minEleFound = true;
                minIndex = j;
            }
            
            if(num == maxK){
                maxEleFound = true;
                maxIndex = j;
            }
            
            if(minEleFound && maxEleFound){
                countSubarrays += Math.min(minIndex, maxIndex) - i + 1; 
            }
        }
        
        return countSubarrays;
    }
}


// https://www.youtube.com/watch?v=FNH9w7TI7j0
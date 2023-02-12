class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        
        int n = nums.length;
        
        long count = 0;
        
        for(int i=0;i<n;i++){
            count += (binarySearch1(nums, nums[i], i+1, n, upper) - binarySearch2(nums, nums[i], i+1, n, lower));
        }
        
        return count;
    }
    
    private long binarySearch1(int [] nums, int currentNum, int startIndex, int endIndex, int upper){
        
        while(startIndex < endIndex){
            int mid = startIndex + (endIndex - startIndex)/2;
            
            if(nums[mid] > (upper - currentNum)){
                endIndex = mid;
            }
            else{
                startIndex = mid + 1;
            }
        }
        
        return startIndex;
    }
    
    private long binarySearch2(int [] nums, int currentNum, int startIndex, int endIndex, int lower){
        
        while(startIndex < endIndex){
            int mid = startIndex + (endIndex - startIndex)/2;
            
            if(nums[mid] < (lower - currentNum)){
                startIndex = mid + 1;
            }
            else{
                endIndex = mid;
            }
        }
        
        return startIndex;
    }
}
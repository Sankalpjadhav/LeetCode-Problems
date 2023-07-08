class Solution {
    public int pivotIndex(int[] nums) {
        // Brute Force
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        
        int [] prefix = new int[n];
        int [] suffix = new int[n];
        
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1] + nums[i+1];
        }
        
        for(int j=0;j<n;j++){
            if(prefix[j] == suffix[j]){
                return j;
            }
        }
        
        return -1;
    }
}

/*
    public int pivotIndex(int[] nums) {
        // Brute Force
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            int leftSum = 0;
            for(int j=i-1;j>=0;j--){
                leftSum += nums[j];
            }
            int rightSum = 0;
            for(int k=i+1;k<n;k++){
                rightSum += nums[k];
            }
            
            if(leftSum == rightSum){
                return i;
            }
        }
        
        return -1;
    }
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefixProduct = new int[n];
        int [] suffixProduct = new int[n];
        
        // Prefix Product except self
        prefixProduct[0] = 1;
        for(int i=1;i<n;i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }
        
        // Suffix Product except self
        suffixProduct[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
        }
        
        int [] answer = new int[n];
        
        for(int i=0;i<n;i++){
            answer[i] = prefixProduct[i] * suffixProduct[i];
        }
        
        return answer;
    }
}
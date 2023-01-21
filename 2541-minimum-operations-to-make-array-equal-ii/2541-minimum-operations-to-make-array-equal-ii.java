class Solution {
    // https://www.youtube.com/watch?v=k9jEPl5tC0s
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        if(k == 0){
            for(int i=0; i<n; i++){
                if(nums1[i] != nums2[i]){
                    return -1;
                }
            }
            
            return 0;
        }
        
        long ans = 0;
        long debt = 0;
        
        for(int i=0; i<n; i++){
            int delta = nums1[i] - nums2[i];
            
            if(Math.abs(delta) % k != 0){
                return -1;
            }
            
            debt += delta;
            ans += Math.abs(delta/k);
        }
        
        if(debt == 0){
            return ans/2; // Divide by 2 bcoz at a single time we are making 2 operations that is adding k and removing k
        }
        
        return -1;
    }
}
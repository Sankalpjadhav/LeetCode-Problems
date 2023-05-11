class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int [][] memo = new int[n1][n2];
        
        for(int i=0;i<n1;i++){
            Arrays.fill(memo[i], -1);
        }
        
        return helper(0, 0, memo, nums1, nums2);
    }
    
    private int helper(int index1, int index2, int [][] memo, int [] nums1, int [] nums2){
        if(index1 == nums1.length || index2 == nums2.length){
            return 0;
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        int best = 0;
        
        if(nums1[index1] == nums2[index2]){
            best = Math.max(best, helper(index1+1, index2+1, memo, nums1, nums2)+1);
        }
        
        best = Math.max(best, Math.max(helper(index1+1, index2, memo, nums1, nums2), helper(index1, index2+1, memo, nums1, nums2)));
        
        return memo[index1][index2] = best;
    }
}
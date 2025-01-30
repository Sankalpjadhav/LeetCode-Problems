class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int longest = 0;
        int [][] dp = new int[m+1][n+1];
        for(int index1=1;index1<=m;index1++){
            for(int index2=1;index2<=n;index2++){
                if(nums1[index1-1] == nums2[index2-1]){
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                    longest = Math.max(longest, dp[index1][index2]);
                }
                else{
                    dp[index1][index2] = 0;
                }
            }
        }
        return longest;
    }

    
}

/*
MEMOIZATION: TC: O(m*n), SC: O(m+n) + O(m*n)

public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int [] longest = {0};
        int [][] memo = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i], -1);
        }
        findSubarrayLength(m, n, nums1, nums2, longest, memo);
        return longest[0];
    }

    private int findSubarrayLength(int index1, int index2, int [] nums1, int [] nums2, int [] longest, int [][] memo){
        if(index1 == 0 || index2 == 0){
            return 0;
        }

        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }

        int result = 0;
        if(nums1[index1-1] == nums2[index2-1]){
            result = 1 + findSubarrayLength(index1-1, index2-1, nums1, nums2, longest, memo);
        }
        else{
            result = 0;
        }

        findSubarrayLength(index1-1, index2, nums1, nums2, longest, memo);
        findSubarrayLength(index1, index2-1, nums1, nums2, longest, memo);

        longest[0] = Math.max(longest[0], result);
        return memo[index1][index2] = result;
    }

RECURSION: TC: Exponential, SC: O(m+n);
public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int [] longest = {0};
        findSubarrayLength(m, n, nums1, nums2, longest);
        return longest[0];
    }

    private int findSubarrayLength(int index1, int index2, int [] nums1, int [] nums2, int [] longest){
        if(index1 == 0 || index2 == 0){
            return 0;
        }

        int result = 0;
        if(nums1[index1-1] == nums2[index2-1]){
            result = 1 + findSubarrayLength(index1-1, index2-1, nums1, nums2, longest);
        }
        else{
            result = 0;
        }

        findSubarrayLength(index1-1, index2, nums1, nums2, longest);
        findSubarrayLength(index1, index2-1, nums1, nums2, longest);

        longest[0] = Math.max(longest[0], result);
        return result;
    }
*/
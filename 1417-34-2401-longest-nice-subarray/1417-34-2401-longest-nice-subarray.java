class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;

        int start = 0;
        int currentAnd = 0; // To store the cumulative OR of the subarray
        int maxLength = 0;

        for (int end = 0; end < n; end++) {
            // Add the current element to the OR
            while ((currentAnd & nums[end]) != 0) {
                // Shrink the window from the left if it's not "nice"
                currentAnd ^= nums[start]; // XOR is used to remove the contribution of nums[start] from the currentAnd. (x^x=0) 
                start++;
            }
            // Expand the window by including the contribution of nums[end]
            currentAnd |= nums[end];
            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}

/*
Brute force solution: n^4

public int longestNiceSubarray(int[] nums) {
        int n = nums.length;

        int maxLength = 0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                boolean isNice = true;
                // Check if the subarray nums[i:j+1] is nice
                for (int x = i; x <= j; x++) {
                    for (int y = x + 1; y <= j; y++) {
                        if ((nums[x] & nums[y]) != 0) {
                            isNice = false;
                            break;
                        }
                    }
                    if (!isNice) break;
                }
                if (isNice) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
*/
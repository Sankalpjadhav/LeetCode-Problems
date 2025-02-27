class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLength = 0;

        // Map array values to their indices for quick lookups
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate through all pairs (j, i)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = arr[i] - arr[j];
                // Check if `prev` exists and comes before `j`
                if (prev < arr[j] && indexMap.containsKey(prev)) {
                    int k = indexMap.get(prev);
                    int length = dp.getOrDefault(k * n + j, 2) + 1; // Get dp[k][j], default to 2
                    dp.put(j * n + i, length); // Update dp[j][i]
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }
}



/*

 public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<String, Integer> memo = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxLength = Math.max(maxLength, 2 + helper(arr, i, j, memo));
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }

    private int helper(int[] arr, int prevIndex1, int prevIndex2, HashMap<String, Integer> memo) {
        String key = prevIndex1 + "_" + prevIndex2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int nextValue = arr[prevIndex1] + arr[prevIndex2];
        int maxLength = 0;

        for (int i = prevIndex2 + 1; i < arr.length; i++) {
            if (arr[i] == nextValue) {
                maxLength = Math.max(maxLength, 1 + helper(arr, prevIndex2, i, memo));
            }
        }

        memo.put(key, maxLength);
        return maxLength;
    }

Brute force: Recursion

public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;

        int result = helper(0, -1, -1, n, arr);
        if(result < 3) return 0;

        return result;
    }

    private int helper(int index, int prevIndex1, int prevIndex2, int n, int [] arr){
        if (index == n) {
            return 0;
        }

        // Option 1: Skip the current element
        int notTake = helper(index + 1, prevIndex1, prevIndex2, n, arr);

        // Option 2: Take the current element
        int take = 0;
        if (prevIndex1 == -1 || prevIndex2 == -1 || (arr[index] == arr[prevIndex1] + arr[prevIndex2])) {
            take = 1 + helper(index+1, index, prevIndex1, n, arr);
        }

        return Math.max(notTake, take);
    }
*/
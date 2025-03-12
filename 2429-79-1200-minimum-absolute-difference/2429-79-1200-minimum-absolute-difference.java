class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Find the minimum absolute difference
        int minAbsoluteDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            minAbsoluteDiff = Math.min(minAbsoluteDiff, diff);
        }

        // Step 3: Find all pairs with the minimum absolute difference
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minAbsoluteDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
class Solution {
    private List<Integer> blacklist;
    private int n;

    public Solution(int n, int[] blacklist) {
        Arrays.sort(blacklist); // Sort the blacklist for binary search
        this.blacklist = new ArrayList<>();
        for (int b : blacklist) {
            this.blacklist.add(b);
        }
        this.n = n;
    }
    
    public int pick() {
        Random rand = new Random();
        int num = rand.nextInt(n - blacklist.size()); // Generate a number in the valid range

        // Binary search to find the number of blacklisted numbers <= 'num'
        int left = 0, right = blacklist.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (blacklist.get(mid) <= num + mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Add the offset caused by blacklisted numbers
        return num + left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
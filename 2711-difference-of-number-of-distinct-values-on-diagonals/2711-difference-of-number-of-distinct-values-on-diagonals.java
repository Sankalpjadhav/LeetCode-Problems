class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> set1 = new HashSet<>();
                Set<Integer> set2 = new HashSet<>();

                int r = i - 1;
                int c = j - 1;
                while (r >= 0 && c >= 0) {
                    set1.add(grid[r--][c--]);
                }

                r = i + 1;
                c = j + 1;
                while (r < m && c < n) {
                    set2.add(grid[r++][c++]);
                }

                ans[i][j] = Math.abs(set1.size() - set2.size());
            }
        }

        return ans;
    }
}
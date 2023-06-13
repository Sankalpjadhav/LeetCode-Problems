class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, cnt = 0;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            map.put(row, map.getOrDefault(row, 0) + 1);
        }
        for(int j = 0; j < n; j++) {
            List<Integer> col = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                col.add(grid[i][j]);
            }
            if(map.containsKey(col)) {
                cnt += map.get(col);
            }
        }
        return cnt;
    }
}
class Solution {
    int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;

    public int swimInWater(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean [][] visited = new boolean[m][n];
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int [] current = pq.poll();
            int currentTime = current[0];
            int row = current[1];
            int col = current[2];
            if(row == m-1 && col == n-1) return currentTime;

            for(int [] direction: directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && !visited[newRow][newCol]){
                    pq.add(new int[]{Math.max(currentTime, grid[newRow][newCol]), newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1111;
    }

    
}

/*
Brute force approach: 4 ^ (m*n)

public int swimInWater(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean [][] visited = new boolean[m][n];

        return dfs(0, 0, visited, grid, 0);
    }

    // Here the approach is to generate all possible paths and find out smallest of all maximums in all paths.
    private int dfs(int row, int col, boolean [][] visited, int [][] grid, int time){
        if(row == m-1 && col == n-1){
            return Math.max(grid[row][col], time);
        }

        if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col]){
            return Integer.MAX_VALUE;
        }    
        
        visited[row][col] = true;
        int minTime = Math.max(grid[row][col], time);
        int result = Integer.MAX_VALUE;
        for(int [] direction: directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            result = Math.min(result, dfs(newRow, newCol, visited, grid, minTime));
        }

        visited[row][col] = false;
        return result;
    }
*/

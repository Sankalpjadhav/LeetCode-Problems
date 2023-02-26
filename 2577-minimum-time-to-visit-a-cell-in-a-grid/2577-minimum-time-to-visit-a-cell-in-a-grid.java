class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
    
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0}); // (grid[row][col], row, col)

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], row = curr[1], col = curr[2];

            if (row == m - 1 && col == n - 1) return time;
            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] dir : dirs) {
                int r = row + dir[0], c = col + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) continue;
                int wait = ((grid[r][c] - time) % 2 == 0) ? 1 : 0;
                pq.offer(new int[]{Math.max(grid[r][c] + wait, time + 1), r, c});
            }
        }
        
        return -1;
    }
}

/*

Intuition
We want to find minimum time to reach bottom right cell. We'll have to traverse the matrix as the time in each cell allows. We can use a priority queue to keep track of time.
Some things to keep in mind:

If we can not move to the neighboring cells from starting position we can not move anywhere in the matrix hence answer is -1.

But if we can move to the neighboring cells from starting position, we can move anywhere in the matrix. We can wait by playing "ping pong" between previous cell and current cell till a neighboring cell opens up.

Approach
If grid[0][1] > 1 and grid[1][0] > 1 we can not move anywhere from cell grid[0][0] hence answer is -1
Use priority queue to find next cell with minimum time to move to it

****IMPORTANT****
If time for a neighbor (target) cell is > 1 + time for current cell. We can not directly move to target cell. We will have to "ping pong" between previous cell and current cell. When playing ping pong between previous and current cell there can be two cases.
Let's say time for target cell is 4 and current time is 2, difference = 2 (even).
Move to prev cell, time = 3
Move to curr cell, time = 4
Move to target cell, time = 5.
Hence we reach target cell with time: target cell time + 1 when difference between target cell time and curr cell time is even.

Let's say time for target cell is 5 and current time is 2, difference = 3 (odd).
Move to prev cell, time = 3
Move to curr cell, time = 4
Move to target cell, time = 5.
Hence we reach target cell with time: target cell time when difference between target cell time and curr cell time is odd.
This "ping pong" is captured in the wait variable in the code

Complexity
Time complexity: O(mnlog(mn))
Space complexity: O(mn)

*/
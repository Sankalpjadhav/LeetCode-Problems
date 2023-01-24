class Solution {
    private int n;
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.poll();
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    int[] pos = numToPos(next);
                    if (board[pos[0]][pos[1]] != -1) {
                        next = board[pos[0]][pos[1]];
                    }
                    if (next == n * n) {
                        return step;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    private int[] numToPos(int target) {
        int row = (target - 1) / n, col = (target - 1) % n;
        int x = n - 1 - row, y = row % 2 == 0 ? col : n - 1 - col;
        return new int[]{x, y};
    }
    
}
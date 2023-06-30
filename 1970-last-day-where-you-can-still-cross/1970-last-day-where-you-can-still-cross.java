class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int lastDayPossible = 0;
        int left = 1;
        int right = cells.length;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canWeWalk(cells, mid, row, col)){
                lastDayPossible = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return lastDayPossible;
    }
    
    private boolean canWeWalk(int [][] cells, int day, int row, int col){
        int [][] grid = new int[row][col];
        
        for(int i=0;i<day;i++){
            grid[cells[i][0]-1][cells[i][1]-1] = 1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int column=0;column<col;column++){
            if(grid[0][column] == 0){
                queue.add(new int[]{0, column});
                grid[0][column] = 2; // marking it as visited.
            }
        }
        
        int [][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        while(!queue.isEmpty()){
            int [] cell = queue.poll();
            //System.out.println(cell[0] + "-" + cell[1]);
            if(cell[0] == row - 1){
                // If we were able to reach from top to bottom
                return true;
            }
            
            for(int dir=0;dir<directions.length;dir++){
                int nextX = cell[0] + directions[dir][0];
                int nextY = cell[1] + directions[dir][1];
                
                if(nextX < 0 || nextY < 0 || nextX == row || nextY == col || grid[nextX][nextY] == 1 || grid[nextX][nextY] == 2){
                    continue;
                }
                
                queue.add(new int[]{nextX, nextY});
                grid[nextX][nextY] = 2;
            }
        }
        
        return false;
    }
    
}

// Was not able to solve in first attempt: https://www.youtube.com/watch?v=BA3cgYVr36o
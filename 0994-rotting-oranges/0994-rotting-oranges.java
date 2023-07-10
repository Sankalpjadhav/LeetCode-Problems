class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int countOfFreshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    countOfFreshOranges++;
                }
            }
        }
        
        if(countOfFreshOranges == 0){
            return 0;
        }
        
        boolean [][] visited = new boolean[m][n];
        int [][] directions = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            while(size-- > 0){
                int [] rottenOrange = queue.poll();
                for(int [] dir : directions){
                    int newX = rottenOrange[0] + dir[0];
                    int newY = rottenOrange[1] + dir[1];
                    
                    if(newX < 0 || newX == m || newY < 0 || newY == n || visited[newX][newY]){
                        continue;
                    }
                    
                    if(grid[newX][newY] == 1){
                        visited[newX][newY] = true; 
                        queue.add(new int[]{newX, newY});
                        countOfFreshOranges--;
                    }
                }
            }
        }
        
        return countOfFreshOranges == 0 ? time-1 : -1;
    }
}
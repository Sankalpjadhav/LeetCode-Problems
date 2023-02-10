class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int []> queue = new LinkedList<>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        if(queue.size() == m*n){
            // No water
            return -1;
        }
        
        int [] xCoordinate = {-1,0,1,0};
        int [] yCoordinate = {0,-1,0,1};
        int distance = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++;
            while(size-- > 0){
                int [] present = queue.poll();
                
                for(int i=0;i<4;i++){
                    int newX = present[0] + xCoordinate[i];
                    int newY = present[1] + yCoordinate[i];
                    
                    if(newX >= 0 && newY >=0 && newX < m && newY < n && grid[newX][newY] == 0){
                        grid[newX][newY] = 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        
        return distance-1;
    }
}
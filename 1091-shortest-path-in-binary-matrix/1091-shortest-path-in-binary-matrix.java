class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;
        int [][] directions = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
        queue.add(new int[]{0,0});
        grid[0][0] = 2; // Marking as visited
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for(int i=0;i<size;i++){
                int [] currentPosition = queue.poll();
                
                if(currentPosition[0] == n-1 && currentPosition[1] == n-1){
                    return ans;
                }
                
                for(int [] dir : directions){
                    int newPositionX = currentPosition[0] + dir[0];
                    int newPositionY = currentPosition[1] + dir[1];
                    
                    if(newPositionX < n && newPositionX >=0 && newPositionY < n && newPositionY >=0 && grid[newPositionX][newPositionY]==0){
                        queue.add(new int[]{newPositionX, newPositionY});
                        grid[newPositionX][newPositionY] = 2;
                    }
                }
            }
        }
        
        return -1;
    }
    
}
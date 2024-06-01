class Pair{
    int row;
    int col;
    
    Pair(int _row, int _col){
        row = _row;
        col = _col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        
        int countOfFreshOranges = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1){
                    countOfFreshOranges++;
                }
            }
        }
        
        if(countOfFreshOranges == 0){
            return 0;
        }
        
        if(queue.size() == 0){
            return -1;
        }
        
        int [] rowArray = {-1,0,1,0};
        int [] colArray = {0,1,0,-1};
        int time = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            //System.out.println("size = "+size);
            
            while(size-- > 0){
                Pair pair = queue.poll();
                
                for(int i=0;i<4;i++){
                        int newRow = pair.row + rowArray[i];
                        int newCol = pair.col + colArray[i];
                        
                        if(newRow >=0 && newCol >=0 && newRow < m && newCol < n && grid[newRow][newCol] == 1){
                            grid[newRow][newCol] = 2;
                            queue.add(new Pair(newRow, newCol));
                        }
                }
            }
            time++;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return time-1;
    }
}
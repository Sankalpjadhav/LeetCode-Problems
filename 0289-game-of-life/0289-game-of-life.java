class Solution {
    public void gameOfLife(int[][] board) {
        /*
        Tweeking/Combining the rules:
        1. Any live cell (1), with fewer than 2 live neighbours or more than 3 live neighbours dies (0). 1 is changed to 0.
        2. Any dead cell (0), with exactly 3 live neighbours becomes a live cell (1). 0 is changed to 1
        
        If we directly change the values in the board, it may affect while calculating the state of its neighbours.
        So, we need to have some intermediate states:
        if 0 becomes 1 -> then use intermediate state value as 3
        if 1 becomes 0 -> then use intermediate state value as -3
        
        NOTE: You can use any intermediate state value aprat from 0 & 1.
        
        Then at the end, update the value from 3 to 1 and -3 to 0.
        */
        int m = board.length;
        int n = board[0].length;
        
        int [][] directions = {{-1,0}, {-1,-1}, {0, -1}, {1, -1}, {1, 0}, {1,1}, {0, 1}, {-1, 1}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int numberOfLivesNeighbours = calculateLiveNeighbours(i, j, board, directions);
                
                //System.out.println("("+i+", "+j+") = "+ numberOfLivesNeighbours);
                
                if(board[i][j] == 1 || board[i][j] == -3){
                    if(numberOfLivesNeighbours < 2 || numberOfLivesNeighbours > 3){
                        board[i][j] = -3;
                    }
                }
                else{ // 0 or 3
                    if(numberOfLivesNeighbours == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        update(board);
        
    }
    
    private void update(int [][] board){
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                else if(board[i][j] == -3){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int calculateLiveNeighbours(int i, int j, int [][] board, int [][] directions){
        int count = 0;
        
        for(int k=0;k<directions.length;k++){
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            
            if(newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length){
                continue;
            }
            
            if(board[newX][newY] == 1 || board[newX][newY] == -3){
                count++;
            }
        }
        
        return count;
    }
}
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int []> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                    queue.add(new int[]{i, 0});
            }
            if(board[i][n-1] == 'O'){
                queue.add(new int[]{i, n-1});
            }
        }

        for(int j=1;j<n;j++){
            if(board[0][j] == 'O'){
                queue.add(new int[]{0, j});
            }
            if(board[m-1][j] == 'O'){
                queue.add(new int[]{m-1, j});
            }
        }

        int [][] directions = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()){
            int [] currentCell = queue.poll();
            board[currentCell[0]][currentCell[1]] = '1';
            for(int [] direction: directions){
                int newI = currentCell[0] + direction[0];
                int newJ = currentCell[1] + direction[1];
                if(newI >= 0 && newJ >= 0 && newI < m && newJ < n && board[newI][newJ] == 'O'){
                    queue.add(new int[]{newI, newJ});    
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
}


/*
Brute force solution: For every 'O' (excluding the O's on the border) make a DFS call
In DFS call check if we are finding 'X' in all 4 directions. If yes, then update that 
cell to 'X', else do not update. 
*/
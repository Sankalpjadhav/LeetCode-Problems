class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char [][] board){
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                if(board[i][j] == '.'){
                    for(char ch='1';ch<='9';ch++){
                        if(valid(ch, i, j, board)){
                            board[i][j] = ch;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char ch, int row, int col, char [][] board){
        for(int i=0;i<=8;i++){
            // checking varying column and fixed row
            if(board[row][i] == ch){
                return false;
            }
            // checking varying row and fixed column
            if(board[i][col] == ch){
                return false;
            }
            // checking submatrix
            if(board[3*(row/3) + i/3][3*(col/3)+ i%3] == ch){
                return false;
            }
        }

        return true;
    }
}
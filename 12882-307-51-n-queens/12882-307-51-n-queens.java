class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        boolean [] columns = new boolean[n];
        boolean [] normalDiagonal = new boolean[2*n-1];
        boolean [] reverseDiagonal = new boolean[2*n-1];

        solve(0, board, result, columns, normalDiagonal, reverseDiagonal);
        return result;
    }

    private List<String> constructString(char [][] board){
        List<String> result = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row = new String(board[i]);
            result.add(row);
        }

        return result;
    }

    private void solve(int row, char[][] board, List<List<String>> result, boolean [] columns, boolean []
    normalDiagonal, boolean [] reverseDiagonal){
        if(row == board.length){
            result.add(constructString(board));
            return;
        }

        for(int j=0;j<board.length;j++){
            if(!columns[j] && !normalDiagonal[row+j] && !reverseDiagonal[row-j+board.length-1]){
                columns[j] = true;
                normalDiagonal[row+j] = true;
                reverseDiagonal[row-j+board.length-1] = true;
                board[row][j] = 'Q';
                solve(row+1, board, result, columns, normalDiagonal, reverseDiagonal);
                board[row][j] = '.';
                columns[j] = false;
                normalDiagonal[row+j] = false;
                reverseDiagonal[row-j+board.length-1] = false;
            }
        }
    }

}

/*
public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        solve(0, board, result);
        return result;
    }

    private List<String> constructString(char [][] board){
        List<String> result = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row = new String(board[i]);
            result.add(row);
        }

        return result;
    }

    private void solve(int row, char[][] board, List<List<String>> result){
        if(row == board.length){
            result.add(constructString(board));
            return;
        }

        for(int j=0;j<board.length;j++){
            if(canBePlaced(row, j, board)){
                board[row][j] = 'Q';
                solve(row+1, board, result);
                board[row][j] = '.';
            }
        }
    }

    private boolean canBePlaced(int row, int col, char [][] board){

        for(int i=row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // Check / diagonal (top-right)
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check \ diagonal (top-left)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
*/
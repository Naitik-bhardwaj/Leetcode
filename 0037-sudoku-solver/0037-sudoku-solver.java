class Solution {
    public void solveSudoku(char[][] board) {
        int row = 0, col=0;
        solve(board, row, col);
    }
    public boolean solve(char[][] board, int row, int col){
        if(col==9){
            row++;
            col = 0;
        }
        if(row==9) return true;
        if(board[row][col] != '.'){
            return solve(board, row, col+1);
        }
        for(char k='1';k<='9';k++){
            if(board[row][col] == '.' && isSafe(board, row, col, k)){
                board[row][col] = k ;
                if(solve(board, row, col+1)) return true;
                board[row][col] = '.';
            }      
        }
        return false;
    }
    public boolean isSafe(char[][] board, int row, int col, char k){
        for(int i=0;i<9;i++){
            if(board[i][col] == k){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(board[row][j] == k){
                return false;
            }
        }
        int sr = row/3*3;
        int sc =col/3*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j] == k){
                    return false;
                } 
            }
        }
        return true;
    }
}
class Solution {
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess[i][j] = '.';
            }
        }
        return placeQueen(chess, 0);
        
    }
    public boolean isSafe(char[][] chess, int row, int col){
        //up
        for(int i=row-1;i>=0;i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        //left diag up
        for(int i=row-1, j=col-1;i>=0 && j>=0; i--, j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        //right diag up
        for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public int placeQueen(char[][] chess, int row){
        if(row == chess.length){
            return 1;
        }
        int count=0;
        for(int j=0;j<chess.length;j++){
            if(isSafe(chess, row, j)){
                chess[row][j] = 'Q';
                count += placeQueen(chess, row+1);
                chess[row][j] = '.';
            }
        }
        return count;
    }
}
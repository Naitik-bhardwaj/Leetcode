class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] chess = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess[i][j] = '.';
            }
        }
        placeQueen(ans, chess, 0);
        return ans;
    }
    public boolean isPlace(char[][] chess, int row, int col){
        //up 
        for(int i=row-1;i>=0;i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        //diag left up
        for(int i=row-1, j=col-1; i>=0 && j>=0;i--, j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        //diag right up
        for(int i=row-1,j=col+1;i>=0 && j<chess.length; i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public void placeQueen(List<List<String>> ans, char[][] chess, int row){
        if(row == chess.length){
            ans.add(build(chess));
            return;
        }

        for(int j=0;j<chess.length;j++){
            if(isPlace(chess, row, j)){
                chess[row][j] = 'Q';
                placeQueen(ans, chess, row+1);
                chess[row][j] = '.';
            }
        }
    }


    public List<String> build(char[][] chess){
        List<String> path = new ArrayList<>();
        for(int i=0;i<chess.length;i++){
            path.add(new String(chess[i]));
        }
        return path;
    }
    
}
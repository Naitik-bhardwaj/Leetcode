class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean[][] row = new boolean[n][n];
        boolean[][] col = new boolean[n][n];
        boolean[][] grid = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int idx = ((i/3)*3 + j/3);
                if(row[i][num] || col[j][num] || grid[idx][num]){
                    return false;
                }
                row[i][num] = true;
                col[j][num] = true;
                grid[idx][num] = true;
            }
        }
        return true;
    }
    
}
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = search(board, word, i, j, 0);
                    if(ans) return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int cr, int cc, int idx){
        if(idx == word.length()) return true;
        if(cr<0 || cc<0 || cr>board.length-1 || cc > board[0].length-1 || board[cr][cc] == '*' || board[cr][cc] != word.charAt(idx)){
            return false;
        }
        char temp = board[cr][cc];
        board[cr][cc] = '*';
        //up
        boolean s1 = search(board, word, cr-1, cc, idx+1);
        //down
        boolean s2 = search(board, word, cr+1, cc, idx+1);
        //left
        boolean s3 = search(board, word, cr, cc-1, idx+1);
        //right
        boolean s4 = search(board, word, cr, cc+1, idx+1);

        board[cr][cc] = temp;
        return s1 || s2 || s3 || s4;
    }
}
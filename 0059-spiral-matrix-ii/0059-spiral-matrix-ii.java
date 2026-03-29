class Solution {
    public int[][] generateMatrix(int n) {
        int count = 1;
        int sr = 0, sc = 0;
        int er = n-1, ec = n-1;
        int[][] mat = new int[n][n];
        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++){
                mat[sr][i] = count++;
            }
            sr++;
            for(int i=sr;i<=er;i++){
                mat[i][ec] = count++;
            }
            ec--;
            for(int i=ec;i>=sc;i--){
                mat[er][i] = count++;
            }
            er--;
            for(int i=er;i>=sr;i--){
                mat[i][sc] = count++;
            }
            sc++;
        }
        return mat;
    }
}
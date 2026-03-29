class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       int sr=0, sc=0, er=matrix.length-1, ec= matrix[0].length-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++){
                ans.add(matrix[sr][i]);
            }
            sr++;
            for(int i=sr;i<=er;i++){
                ans.add(matrix[i][ec]);
            }
            ec--;
            if(sr<=er){
                for(int i=ec;i>=sc;i--){
                    ans.add(matrix[er][i]);
                }
                
            }
            er--;
            if(sc<=ec){
                for(int i=er;i>=sr;i--){
                    ans.add(matrix[i][sc]);
                }
            }
            sc++;
        }
        return ans;
    }
}
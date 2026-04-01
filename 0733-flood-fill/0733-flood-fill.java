class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old_color = image[sr][sc];
        if(image[sr][sc] == color){
            return image;
        }
        solution(image, sr, sc, color, old_color);
        return image;
    }

    public void solution(int[][] image, int cr, int cc, int color, int old_color){

        if(cr<0 || cc<0 || cr>=image.length || cc>=image[0].length || image[cr][cc]!=old_color){
            return;
        }
        image[cr][cc] = color;
        
        solution(image, cr-1, cc, color, old_color);
        solution(image, cr+1, cc, color, old_color);
        solution(image, cr, cc-1, color, old_color);
        solution(image, cr, cc+1, color, old_color);
    }
}
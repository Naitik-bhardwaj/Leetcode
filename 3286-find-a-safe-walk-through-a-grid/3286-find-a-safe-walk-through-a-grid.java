class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int startHealth = health - grid.get(0).get(0);
        if(startHealth <= 0) return false;

        int[][] heal = new int[m][n];
        for(int[] row : heal){
            Arrays.fill(row, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, startHealth});

        heal[0][0] = startHealth;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int currHealth = curr[2];
            if (row == m - 1 && col == n - 1) {
                return true;
            }

            for(int[] dir : directions){
                int newRow = dir[0]+row;
                int newCol = col + dir[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                    continue;
                }

                int newHealth = currHealth - grid.get(newRow).get(newCol);

                if(newHealth <= 0){
                    continue;
                }
                if(newHealth > heal[newRow][newCol]){
                    heal[newRow][newCol] = newHealth;
                    q.offer(new int[] {newRow, newCol, newHealth});
                }
            }
        }
        return false;

    }
}
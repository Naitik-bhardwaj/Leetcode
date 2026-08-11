class Solution {int[] ans;
    private boolean solve(int n ){
        if(n==0) return false;
        if(ans[n] != -1) {
            if(ans[n] == 1) {
                return true;
            } else{
                return false;
            }
        }
        
        for(int i=1;i*i <= n;i++){
            if(solve(n - (i*i)) == false){
                ans[n] = 1;
                return true;
            }
        }
        ans[n] = 0;
        return false;

    }
    public boolean winnerSquareGame(int n) {
        ans= new int[n+1];
        Arrays.fill(ans, -1);
        return solve(n);   
    }
}
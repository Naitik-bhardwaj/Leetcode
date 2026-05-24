class Solution {

    int[] dp;
    int[] arr;
    int d;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;

        int n = arr.length;
        dp = new int[n];

        int ans = 1;

        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i));
        }

        return ans;
    }

    private int dfs(int i) {

        if(dp[i] != 0) return dp[i];

        int best = 1;

        // Right
        for(int j = i + 1; j <= Math.min(i + d, arr.length - 1); j++) {

            if(arr[j] >= arr[i]) break;

            best = Math.max(best, 1 + dfs(j));
        }

        // Left
        for(int j = i - 1; j >= Math.max(i - d, 0); j--) {

            if(arr[j] >= arr[i]) break;

            best = Math.max(best, 1 + dfs(j));
        }

        return dp[i] = best;
    }
}
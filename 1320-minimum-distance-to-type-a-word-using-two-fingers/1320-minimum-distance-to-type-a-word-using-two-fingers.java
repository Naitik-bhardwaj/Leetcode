class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        
        int[][] dp = new int[n][27]; 
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][26] = 0;
        
        for (int i = 1; i < n; i++) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            
            for (int j = 0; j <= 26; j++) {
                if (dp[i - 1][j] == Integer.MAX_VALUE) continue;
                
                // Case 1: same finger types
                dp[i][j] = Math.min(dp[i][j], 
                    dp[i - 1][j] + dist(prev, curr));
                
                // Case 2: other finger types
                dp[i][prev] = Math.min(dp[i][prev], 
                    dp[i - 1][j] + dist(j, curr));
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int j = 0; j <= 26; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        
        return res;
    }
    
    private int dist(int a, int b) {
        if (a == 26) return 0;
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
1class Solution {
2    public int climbStairs(int n) {
3        int dp[] = new int[n+1];
4        dp[0] = 1;
5        for(int i=1;i<n+1;i++){
6            if(i==1) dp[i] = dp[i-1];
7            else{
8                dp[i] = dp[i-1]+dp[i-2];
9            }
10        }
11        return dp[n]; 
12    }
13}
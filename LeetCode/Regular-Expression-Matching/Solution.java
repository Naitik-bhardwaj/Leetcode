1class Solution {
2    private Boolean[][] f;
3    private String s;
4    private String p;
5    private int m;
6    private int n;
7
8    public boolean isMatch(String s, String p) {
9        m = s.length();
10        n = p.length();
11        f = new Boolean[m + 1][n + 1];
12        this.s = s;
13        this.p = p;
14        return dfs(0, 0);
15    }
16
17    private boolean dfs(int i, int j) {
18        if (j >= n) {
19            return i == m;
20        }
21        if (f[i][j] != null) {
22            return f[i][j];
23        }
24        boolean res = false;
25        if (j + 1 < n && p.charAt(j + 1) == '*') {
26            res = dfs(i, j + 2)
27                || (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(i + 1, j));
28        } else {
29            res = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(i + 1, j + 1);
30        }
31        return f[i][j] = res;
32    }
33}
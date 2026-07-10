class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
         int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // original index -> sorted position
        int[] pos = new int[n];

        // component id of sorted position
        int[] comp = new int[n];

        for (int i = 0; i < n; i++) {
            pos[arr[i][1]] = i;
        }

        // Build connected components
        int id = 0;
        comp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i][0] - arr[i - 1][0] > maxDiff)
                id++;
            comp[i] = id;
        }

        // right[i] = farthest position reachable in one edge
        int[] right = new int[n];
        int r = 0;

        for (int i = 0; i < n; i++) {

            while (r + 1 < n &&
                    arr[r + 1][0] - arr[i][0] <= maxDiff) {
                r++;
            }

            right[i] = r;

            if (r == i)
                r++;
        }

        // Binary lifting
        int LOG = 20;
        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++)
            up[0][i] = right[i];

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            int jumps = 0;
            int cur = u;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    cur = up[k][cur];
                    jumps += (1 << k);
                }
            }

            ans[qi] = jumps + 1;
        }

        return ans;
    }
}
import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDur,
                       int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] start = new int[m];
        int[] prefMinDur = new int[m];
        long[] suffMinFinish = new long[m + 1];

        for (int i = 0; i < m; i++) {
            start[i] = rides[i][0];
        }

        prefMinDur[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefMinDur[i] = Math.min(prefMinDur[i - 1], rides[i][1]);
        }

        suffMinFinish[m] = Long.MAX_VALUE;

        for (int i = m - 1; i >= 0; i--) {
            long val = (long) rides[i][0] + rides[i][1];
            suffMinFinish[i] = Math.min(val, suffMinFinish[i + 1]);
        }

        long best = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishFirst =
                    (long) firstStart[i] + firstDur[i];

            int idx = upperBound(start, finishFirst) - 1;

            long cur = Long.MAX_VALUE;

            if (idx >= 0) {
                cur = Math.min(cur,
                        finishFirst + prefMinDur[idx]);
            }

            cur = Math.min(cur,
                    suffMinFinish[idx + 1]);

            best = Math.min(best, cur);
        }

        return best;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
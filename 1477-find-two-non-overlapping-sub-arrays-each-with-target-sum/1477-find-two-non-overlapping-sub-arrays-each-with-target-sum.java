import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        // best[i] = minimum length of a target-sum subarray
        // completely inside arr[0...i]
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        // prefix sum -> index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        int minLen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            prefix += arr[i];

            // We need:
            // prefix - previousPrefix = target
            int required = prefix - target;

            if (map.containsKey(required)) {
                int j = map.get(required);

                // Current subarray = [j + 1 ... i]
                int length = i - j;

                // best[j] is a previous non-overlapping subarray
                if (j >= 0 && best[j] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, length + best[j]);
                }

                minLen = Math.min(minLen, length);
            }

            // Best target-sum subarray found up to index i
            best[i] = minLen;

            // Store current prefix sum
            map.put(prefix, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
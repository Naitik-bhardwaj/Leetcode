import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        
        // required variable
        int[][] bravexuneth = queries;

        int B = (int) Math.sqrt(n) + 1;

        // For small k
        long[][] mul = new long[B][n];
        for (int i = 0; i < B; i++) {
            Arrays.fill(mul[i], 1);
        }

        // Process queries
        for (int[] q : bravexuneth) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k < B) {
                for (int start = l; start < n; start += k) {
                    if (start > r) break;
                    mul[k][start] = (mul[k][start] * v) % MOD;
                }
            } else {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int)((long)nums[i] * v % MOD);
                }
            }
        }

        // Apply small k multipliers
        for (int k = 1; k < B; k++) {
            for (int i = 0; i < n; i++) {
                nums[i] = (int)((long)nums[i] * mul[k][i] % MOD);
            }
        }

        // Final XOR
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
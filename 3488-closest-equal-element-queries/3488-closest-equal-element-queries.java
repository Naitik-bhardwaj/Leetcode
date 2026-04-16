class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: Map values to indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Precompute min distances for each index
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        for (List<Integer> list : map.values()) {
            int size = list.size();

            // If only one occurrence → always -1
            if (size == 1) {
                minDist[list.get(0)] = -1;
                continue;
            }

            for (int i = 0; i < size; i++) {
                int curr = list.get(i);
                int next = list.get((i + 1) % size);
                int prev = list.get((i - 1 + size) % size);

                int dist1 = Math.abs(curr - next);
                dist1 = Math.min(dist1, n - dist1);

                int dist2 = Math.abs(curr - prev);
                dist2 = Math.min(dist2, n - dist2);

                minDist[curr] = Math.min(dist1, dist2);
            }
        }

        // Step 3: Answer queries
        ArrayList<Integer> ans = new ArrayList<>();
        for (int q : queries) {
            ans.add(minDist[q]);
        }
        return ans;
    }
}
class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        // Step 2: check triplets
        for (ArrayList<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int dist = 2 * (list.get(i + 2) - list.get(i));
                    minDist = Math.min(minDist, dist);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<=nums.length - k;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(nums[j]);
            }

            for(int m : set){
                hm.put(m, hm.getOrDefault(m, 0)+1);
            }
        }
        int ans = -1;
        for(int m : hm.keySet()){
            if(hm.get(m) == 1){
                ans = Math.max(ans, m);
            }
        }
        return ans;
    }
}
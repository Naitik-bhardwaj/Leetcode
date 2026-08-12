class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
    
        int j=0,ans = 0;
        for(int i=0;i<nums.length;i++){
            h.put(nums[i], h.getOrDefault(nums[i], 0)+1);

            while(h.get(nums[i]) > k){
                h.put(nums[j], h.get(nums[j])-1);
                j++;
            }
            ans = Math.max(ans, i-j+1);
        }
        return ans;


    }
}
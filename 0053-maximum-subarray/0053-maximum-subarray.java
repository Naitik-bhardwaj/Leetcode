class Solution {
    public int maxSubArray(int[] nums) {
        int cs = nums[0];
        int ms = nums[0];
        for(int i=1;i<nums.length;i++){
            //if(cs < 0) cs = 0;
            cs = Math.max(nums[i], cs+nums[i]);
            ms = Math.max(cs, ms);
        }
        return ms;
    }
}
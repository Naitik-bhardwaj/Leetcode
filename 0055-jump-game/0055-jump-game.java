class Solution {
    public boolean canJump(int[] nums) {
        int minIdx = 0;
        for(int i=0;i<nums.length;i++){
            if(i  > minIdx) return false;
            minIdx = Math.max(minIdx, i+nums[i]);
        }
        return true;
    }
}
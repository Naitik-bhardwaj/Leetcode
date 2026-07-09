class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int finalPos = n-1;
        for(int i=n-2;i>=0;i--){
            if((i+nums[i]) >= finalPos){
                finalPos = i;
            }
        }
        return finalPos == 0;


    }
}
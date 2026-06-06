class Solution {
    public int[] leftRightDifference(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        int[] ans = new int[n];
        for(int num : nums){
            totalSum += num;
        }
        int leftSum = 0;
        for(int i=0;i<n;i++){
            int rightSum = totalSum - leftSum - nums[i];
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return ans;

    }
}
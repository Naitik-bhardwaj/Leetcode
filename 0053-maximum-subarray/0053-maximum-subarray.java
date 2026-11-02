class Solution {
    public int maxSubArray(int[] nums) {
        int prefixSum = 0;
        int minPrefix = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum-minPrefix);
            minPrefix = Math.min(minPrefix, prefixSum);
        }
        return maxSum;

    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int si = 0, ei = 0, count0 = 0, ans = 0;
        while(ei < nums.length){
            if(nums[ei] == 0){
                count0++;
            }
            while(count0 > k){
                if(nums[si] == 0){
                    count0--;
                }
                si++;
            }
            ans = Math.max(ans, ei-si+1);
            ei++;
        }
        return ans;
    }
}
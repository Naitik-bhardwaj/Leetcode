class Solution {
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int freq = 1;
        for(int i=1;i<nums.length;i++){
            if(freq == 0){
                curr = nums[i];
            }
            if(nums[i] != curr){
                freq--;
            }
            else{
                freq++;
            }
        }
        return curr;
    }
}
class Solution {
    public int missingInteger(int[] nums) {
        int seqSum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                seqSum+=nums[i];
            } else{
                break;
            }
        }
        Set<Integer> h = new HashSet<>();
        for(int n : nums){
            h.add(n);
        }
        while(h.contains(seqSum)) seqSum++;
        return seqSum;
    }
}
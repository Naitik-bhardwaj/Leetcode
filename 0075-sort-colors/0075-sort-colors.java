class Solution {
    public void sortColors(int[] nums) {
        int start=0;
        int m=0;
        int end=nums.length-1;
        while(m<=end){
            if(nums[m]==0){
                int temp = nums[start];
                nums[start] = nums[m];
                nums[m] = temp;
                m++;
                start++;
            }
            else if(nums[m]==1) {
                m++;
            }
            else{
                int temp = nums[end];
                nums[end] = nums[m];
                nums[m] = temp;
                end--;
            } 
           
        }
    }
}
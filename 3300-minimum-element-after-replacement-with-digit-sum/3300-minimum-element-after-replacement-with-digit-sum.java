class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int elm = nums[i];
            int sum = 0;
            while(elm > 0){
                int d = elm % 10;
                sum += d;
                elm /= 10;
            }
            nums[i] = sum;
        }
        int min = nums[0];

        for(int i=1;i<n;i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }
}
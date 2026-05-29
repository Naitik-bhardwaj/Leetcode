class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int elm = nums[i];
            int sum = 0;
            while(elm > 0){
                int d = elm % 10;
                sum += d;
                elm /= 10;
            }
            min = Math.min(sum, min);
        }   
        return min;
    }
}
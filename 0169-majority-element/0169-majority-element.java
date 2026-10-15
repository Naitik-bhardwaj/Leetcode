class Solution {
    public int majorityElement(int[] nums) {
        int elm = 0;
        int count = 0;
        for(int n : nums){
            if(count  == 0){
                elm = n;
            }
            if(elm == n){
                count++;
            }else{
                count--;
            }
        }
        return elm;

    }
}
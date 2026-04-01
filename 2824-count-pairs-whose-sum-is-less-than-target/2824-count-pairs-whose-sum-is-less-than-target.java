class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int sr = 0, sc = nums.size()-1;
        int count = 0;
        Collections.sort(nums);
        while(sr<sc){
            
            if(nums.get(sr)+nums.get(sc)<target) {
                count+=(sc-sr);
                sr++;
            } 
            else{
                sc--;
            }
        }
        return count;
    }
}
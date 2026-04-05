class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == key){
                map.put(nums[i+1], map.getOrDefault(nums[i+1], 0)+1);
            }
        }
        int maxCount = 0 , maxValue=0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() > maxCount) {
                maxCount = e.getValue();
                maxValue = e.getKey();
            }
        }
        return maxValue;
    }
}
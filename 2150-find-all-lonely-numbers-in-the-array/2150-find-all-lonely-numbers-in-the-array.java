class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int elm : nums){
            map.put(elm, map.getOrDefault(elm, 0)+1);

        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int elm : nums){
            if(map.get(elm) > 1 || map.containsKey(elm+1) || map.containsKey(elm-1)){
                continue;
            }
            ans.add(elm);
        }
        return ans;
    }
}
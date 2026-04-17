class Solution {       
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, list);
        return ans;
    }
    public void helper(int[] nums, boolean[] visited, List<Integer> list){
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i] == true) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, list);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
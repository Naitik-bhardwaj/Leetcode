class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        solve(nums,visited, list);
        return ans;
    }
    public void solve(int[] nums, boolean[] visited,  List<Integer> list){
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            if(visited[i] == true){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            solve(nums, visited, list);
            list.remove(list.size()-1);
            visited[i]  = false;
        }
    }
}
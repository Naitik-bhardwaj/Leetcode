class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        ans1.add(nums[0]);
        ans2.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(ans1.get(ans1.size()-1) > ans2.get(ans2.size()-1)){
                ans1.add(nums[i]);
            } else{
                ans2.add(nums[i]);
            }
        }
        int n = ans1.size();int m = ans2.size();
        int[] arr = new int[m+n];
        for(int i=0;i<n;i++){
            arr[i] = ans1.get(i);
        }
        for(int i=0;i<m;i++){
            arr[n+i] = ans2.get(i);
        }
        return arr;
    }
}
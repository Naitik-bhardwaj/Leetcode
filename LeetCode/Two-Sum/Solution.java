1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int[] ans = new int[2]; 
4
5        for(int i=0;i<nums.length;i++){
6            for(int j=i+1;j<nums.length;j++){
7                if(nums[i]+nums[j]==target) {
8                    ans[0] = i;
9                    ans[1] = j;
10                    break; 
11                }
12            }
13        }
14    return ans;
15    }
16}
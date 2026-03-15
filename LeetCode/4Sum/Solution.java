1import java.util.*;
2class Solution {
3    public List<List<Integer>> fourSum(int[] nums, int target) {
4        int n = nums.length;
5        List<List<Integer>> ans = new ArrayList<>();
6        Arrays.sort(nums);
7        for(int i=0;i<n-3;i++){
8            if(i>0 && nums[i] == nums[i-1]) continue;
9            for(int j=i+1;j<n-2;j++){
10                if(j>i+1 && nums[j] == nums[j-1]) continue;
11                int sp = j+1, ep = n-1;
12                while(sp < ep){
13                    long sum = (long)nums[i]+nums[j] + nums[sp]+ nums[ep];
14                    if(sum == target){
15                        ans.add(Arrays.asList(nums[i], nums[j], nums[sp], nums[ep]));
16                        sp++; ep--;
17
18                        while(sp < ep && nums[sp] == nums[sp-1]) sp++;
19                        while(sp < ep && nums[ep] == nums[ep+1]) ep--;
20                    }
21                    else if(sum<target){
22                        sp++;
23                    }
24                    else{
25                        ep--;
26                    }
27                }
28            }
29        }
30        return ans;
31    }
32}
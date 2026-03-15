1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        int n = nums.length;
4        Arrays.sort(nums);
5        List<List<Integer>> ans = new ArrayList<>();
6        for(int i=0;i<n;i++){
7            if(i>0 && nums[i]==nums[i-1]){
8                continue;
9            }
10            int sp=i+1,  ep=n-1;
11            while(sp<ep){
12                int sum = nums[i]+nums[sp]+nums[ep];
13                if(sum==0){
14                    ans.add(Arrays.asList(nums[i],nums[sp], nums[ep]));
15                    sp++;
16                    ep--;
17            
18                    while(sp<ep && nums[ep]==nums[sp-1]){
19                        sp++;
20                    } 
21                    while(sp<ep && nums[ep]==nums[ep+1]){
22                        ep--;
23                    }
24                }
25                else if(sum<0){
26                    sp++;
27                } else{
28                    ep--;
29                }
30            }
31        }
32        return  ans;
33    }
34}
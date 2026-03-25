class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int sp=i+1,  ep=n-1;
            while(sp<ep){
                int sum = nums[i]+nums[sp]+nums[ep];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i], nums[sp], nums[ep]));
                    sp++;
                    ep--;
                    //left same value skip
                    while(sp < ep && nums[sp]==nums[sp-1]){
                        sp++;
                    }
                    //right same value skip
                    while(sp < ep && nums[ep]==nums[ep+1]){
                        ep--;
                    }
                }
                else if(sum<0){
                    sp++;
                } 
                else{
                    ep--;
                }
            }
        }
        return  ans;
    }
}
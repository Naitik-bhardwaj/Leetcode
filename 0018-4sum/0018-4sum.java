import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int sp = j+1, ep = n-1;
                while(sp < ep){
                    long sum = (long)nums[i]+nums[j] + nums[sp]+ nums[ep];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[sp], nums[ep]));
                        sp++; ep--;

                        while(sp < ep && nums[sp] == nums[sp-1]) sp++;
                        while(sp < ep && nums[ep] == nums[ep+1]) ep--;
                    }
                    else if(sum<target){
                        sp++;
                    }
                    else{
                        ep--;
                    }
                }
            }
        }
        return ans;
    }
}
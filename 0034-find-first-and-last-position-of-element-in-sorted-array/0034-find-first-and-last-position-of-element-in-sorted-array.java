class Solution {
    public int[] searchRange(int[] nums, int target) {
        int fv = first(nums, target);
        int lv = last(nums, target);
        int[] ans = {fv, lv};
        return ans;
    }
    
    
    public int first(int[] nums, int target){
        int f = 0, l = nums.length-1;
        
        while(f<=l){
            int mid = (f+l)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target) return mid;
                else l=mid-1;
            }else if(nums[mid]<target) f =mid+1;
            else l = mid-1;
        }
        return -1;
    }
    public int last(int[] nums, int target){
        int l = 0, r = nums.length-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target) return mid;
                else l=mid+1;
            }else if(nums[mid]<target) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }

    
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = merge(nums1, nums2);
        int n = ans.length;
        if(n % 2 != 0){
            return (double) ans[n/2];
        } else{
            return (double) (ans[n/2] + ans[n/2 - 1])/ 2 ;
        }

    }
    private int[] merge(int[] nums1, int[] nums2){
        int i=0; int k = 0;
        int j = 0;
        int[] ans = new int[nums1.length + nums2.length];
        while(i < nums1.length && j<nums2.length){
            if(nums1[i] >= nums2[j]){
                ans[k++] = nums2[j];
                j++;
            } else{
                ans[k++] = nums1[i];
                i++;
            }
        }
        while(i < nums1.length){
            ans[k++] = nums1[i];
            i++;
        }
        while(j < nums2.length){
            ans[k++] = nums2[j];
            j++;
        }
        return ans;
    }
}
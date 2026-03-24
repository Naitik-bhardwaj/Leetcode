class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] ans = merge(nums1, nums2);
        int n = ans.length;
        if(n%2==0){
            return (double)(ans[n/2]+ans[n/2-1])/2;
        } else{
            return (double)ans[n/2];
        }
    }
    public static int[] merge(int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int p1=0;
        int p2=0;
        int p3=0;
        int[] ans = new int[m+n];
        while(p1<arr1.length || p2<arr2.length){
            int val1 = p1<m ? arr1[p1] : Integer.MAX_VALUE;
            int val2 = p2<n ? arr2[p2] : Integer.MAX_VALUE;
        
            if(val1<val2){
                ans[p3]=val1;
                p1++;
            }else{
                ans[p3]=val2;
                p2++;
            }
            p3++; 
        }
        return ans;
    }
}
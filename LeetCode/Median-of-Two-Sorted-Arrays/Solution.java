1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int[] ans = merge(nums1, nums2);
4        if(ans.length%2==0) {
5            double ans2 = (double)(ans[ans.length/2] + ans[ans.length/2-1])/2;
6            return ans2;
7        }else{
8            double ans2 = (double)(ans[ans.length/2]);
9            return ans2;
10        }
11    }
12    public int[] merge(int[] arr1, int[] arr2) {
13        int[] ans = new int[arr1.length+arr2.length];
14        int p1=0;
15        int p2=0;
16        int p3=0;
17        while(p1<arr1.length || p2<arr2.length) {
18            int val1 = p1<arr1.length ? arr1[p1] : Integer.MAX_VALUE;
19            int val2 = p2<arr2.length ? arr2[p2] : Integer.MAX_VALUE;
20            if(val1<val2) {
21                ans[p3]=val1;
22                p1++;
23            }else{
24                ans[p3]=val2;
25                p2++;
26            }
27            p3++;
28        }
29    return ans;
30    }
31}
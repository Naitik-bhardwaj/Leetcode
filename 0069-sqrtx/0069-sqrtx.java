class Solution {
    public int mySqrt(int x) {
        int l=0;
        int h=x;
        int ans = 0;
        while(l <= h){
            int mid = (l+h)/2;
            if((long) mid*mid <= x){
                ans = mid;
                l = mid+1;
            } else{
                h = mid-1; 
            }
        }
        return ans;
    }
}
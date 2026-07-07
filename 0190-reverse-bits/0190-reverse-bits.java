class Solution {
    public int reverseBits(int n) {
        int res = 0, c = 0;
        while(n!=0){
            if(n%2==1) res = res | 1;

        res = res << 1;
        n = n>>1;
        c++;
        }        
        return (res = res<<(32-c-1));
    }
    
}
class Solution {
    public int reverseBits(int n) {
        int s = 0;
        for(int i=0;i<32;i++){
            s = s << 1;
            s = s | (n&1);
            n = n >> 1;
        }
        
        return s;
    }
    
}
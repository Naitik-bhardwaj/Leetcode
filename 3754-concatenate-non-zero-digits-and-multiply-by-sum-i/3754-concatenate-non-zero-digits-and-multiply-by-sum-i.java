class Solution {
    public long sumAndMultiply(int n) {
        int rev =0;
        while(n!=0){
            int d = n%10;
            
            rev = rev *10 + d;
            n /= 10;
        }
        int sum = 0;
        long x = 0;
        while(rev != 0){
            int d = rev % 10;
            if(d != 0){
                x = x*10 + d;
                sum += d;
            }
            rev /= 10;
        }
        return (long)(x * sum);
    }
}
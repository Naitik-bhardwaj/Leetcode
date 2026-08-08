class Solution {
    private int productDigit(int n){
        int digit = 1;
        while(n>0){
            digit = digit * (n%10);
            n = n/10;
            if(digit == 0) return digit;
        }
        
        return digit;
    }

    public int smallestNumber(int n, int t) {
        for(int i=n;i<=n+10;i++){
            if(productDigit(i) % t == 0){
                return i;
            }
        }
        return -1;
    }
}
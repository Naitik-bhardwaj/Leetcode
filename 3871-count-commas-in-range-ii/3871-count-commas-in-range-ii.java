class Solution {
    public long countCommas(long n) {
        long power = 1000;
        long count=0;
        while(power <= n){
            count += n-power+1;
            if(power > n/1000) break;
            power *= 1000;
        }
        return count;
    }
}
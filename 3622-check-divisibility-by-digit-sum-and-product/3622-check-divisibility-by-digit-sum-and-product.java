class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int product = 1;
        while(n > 0){
            int d = n%10;
            sum += d;
            product *= d;
            n /= 10;
        }
        return temp % (sum + product) == 0;

    }
}
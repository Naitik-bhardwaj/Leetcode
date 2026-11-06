class Solution {
    public double myPow(double x, int n) {

        long binForm = n;
        double ans = 1.0;

        boolean isNegative = binForm < 0;

        if(isNegative){
            binForm = -binForm;
        }

        while(binForm > 0){

            if(binForm % 2 == 1){
                ans *= x;
            }

            x *= x;
            binForm /= 2;
        }

        if(isNegative){
            return 1.0 / ans;
        }

        return ans;
    }
}
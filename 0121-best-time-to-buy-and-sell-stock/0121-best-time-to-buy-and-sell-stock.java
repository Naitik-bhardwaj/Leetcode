class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int max = Integer.MIN_VALUE;
        int cprice = prices[0] ;
        for(int i=1;i<prices.length;i++){
            if(cprice > prices[i]) {
                cprice = prices[i]; 
            }
            if((prices[i] - cprice) > max){
                max = prices[i] - cprice;
            } 
        }
        return max;
    }
}
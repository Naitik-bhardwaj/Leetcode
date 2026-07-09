class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countf=0, countt=0, countn=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5) countf++;
            if(bills[i] == 10){
                if(countf == 0) return false;
                countt++;
                countf--;
            } 
            if(bills[i] == 20 ){
    
                if(countt>=1 && countf >=1) {
                    countt--;
                    countf--;
                }
                else if(countn>=1) {
                    countn--;
                }
                else if(countf >= 3){
                    countf-=3;
                }
                else{
                    return false;
                }
            }  
        }
        return true;
    }
}
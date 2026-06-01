class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        for(int i=0;i<n/2;i++){
            int temp = cost[i];
            cost[i] = cost[n-1-i];
            cost[n-1-i] = temp;
        }
        int ans = 0;
        for(int i=0;i<cost.length;i++){
            if(i % 3 != 2){
                ans += cost[i];
            }
        }
        return ans;
    }
}
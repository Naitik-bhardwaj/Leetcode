class Solution {
    public int maxDistance(int[] colors) {
        int maxDist = 0;
        int n = colors.length;
        //compare with first elm
        for(int i=n-1;i>=0;i--){
            if(colors[i] != colors[0]){
                maxDist = Math.max(i, maxDist);
                break;
            }
        }

        //compare with last elm
        for(int i=0;i<n;i++){
            if(colors[i] != colors[n-1]){
                maxDist = Math.max(maxDist, n-i-1);
                break;
            }
        }
        return maxDist;
    }
}
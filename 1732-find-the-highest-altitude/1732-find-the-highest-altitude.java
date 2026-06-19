class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int maxAlt = 0;
        for(int n : gain){
            alt += n;
            maxAlt = Math.max(maxAlt, alt);
        }
        return maxAlt;
    }

}
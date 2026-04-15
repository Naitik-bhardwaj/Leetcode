class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                int s = Math.abs(i-startIndex);
                int t = Math.min(s, n-s);
                min = Math.min(min, t);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
class Solution {
    public int reverseDegree(String s) {
        int p = 0;
        for(int i=0;i<s.length();i++){
            int rev = 26 - (s.charAt(i)-'a');
            p += rev * (i+1);
        }
        return p;
    }
}
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int f = 0, s=0, t=0;
        int len = word1.length() + word2.length();
        while(f < word1.length() && s < word2.length()){
            str.append(word1.charAt(f++));
            str.append(word2.charAt(s++));
        }
        while(f < word1.length()){
            str.append(word1.charAt(f++));
        }
        while(s < word2.length()){
            str.append(word2.charAt(s++));
        }
        return str.toString();

    }
}
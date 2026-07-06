class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hm = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            while(hm.contains(ch)){
                hm.remove(s.charAt(left));
                left++;
            }
            hm.add(ch);
            max = Math.max(max, right-left+1);
        }
        return max;
    }

}
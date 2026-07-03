class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)) st.append(Character.toLowerCase(ch));
        }

        String original = st.toString();
        String reversed = st.reverse().toString();
        return original.equals(reversed);
    }
}
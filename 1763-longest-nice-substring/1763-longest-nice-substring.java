class Solution {
    public String longestNiceSubstring(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i, j+1);
                if(isNice(sub) && sub.length() > ans.length()){
                    ans = sub;
                }
            }   
        }
        return ans;
    }
    public boolean isNice(String sub){
        HashSet<Character> h = new HashSet<>();
        for(char ch  : sub.toCharArray()){
            h.add(ch);
        }
        for(char ch : sub.toCharArray()){
            if(Character.isLowerCase(ch)){
                if(!h.contains(Character.toUpperCase(ch))){
                    return false;
                }
            } else{
                if(!h.contains(Character.toLowerCase(ch))){
                    return false;
                }
            }
        }
        return true;
    }
}
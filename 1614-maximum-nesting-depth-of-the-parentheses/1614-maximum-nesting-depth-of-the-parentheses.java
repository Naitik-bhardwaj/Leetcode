class Solution {
    public int maxDepth(String s) {
        int maxC = 0;int count = 0;
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i) == '('){
                count++;
                maxC = Math.max(maxC, count);
            }
            else if(s.charAt(i) == ')'){
                count--;
            }
        }
        return maxC;
    }
}
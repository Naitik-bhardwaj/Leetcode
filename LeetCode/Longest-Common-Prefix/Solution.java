1class Solution {
2    public String longestCommonPrefix(String[] strs){
3        if(strs.length == 0 || strs==null) {
4            return "";
5        } 
6        StringBuilder ans = new StringBuilder();
7        Arrays.sort(strs);
8        char[] first = strs[0].toCharArray();
9        char[] last = strs[strs.length-1].toCharArray();
10        for(int i=0; i<first.length;i++){
11            if(first[i]!=last[i]){
12                break;
13            }
14            ans.append(first[i]);
15        }   
16        return ans.toString();
17    }
18}
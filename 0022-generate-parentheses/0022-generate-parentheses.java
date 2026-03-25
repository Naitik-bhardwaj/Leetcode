class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        parenthesis(n, 0, 0, "", list);
        return list;
    }
    public void parenthesis(int n, int open, int close, String ans, List<String> list){
        //if(open==n && close == n)
        if(ans.length() == 2*n){
            list.add(ans);
            return ;
        }
        if(open < n){
            parenthesis(n, open+1, close, ans+"(", list);
        }
        if(close<open){
            parenthesis(n, open, close+1, ans+")", list);
        }
    }
}
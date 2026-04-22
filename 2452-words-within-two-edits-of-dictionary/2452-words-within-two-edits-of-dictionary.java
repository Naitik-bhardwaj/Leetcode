class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String q : queries){
            for(String d : dictionary){
                if(isValid(q, d)){
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }
    private boolean isValid(String q, String d){
        int count = 0;
        for(int i=0;i<q.length();i++){
            if(q.charAt(i) != d.charAt(i)){
                count++;
                if(count > 2) return false;
            }
        }
        return true;
    }
}
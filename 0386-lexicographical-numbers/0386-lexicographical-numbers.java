class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=9;i++){
            print(i, n, list);
        }
        return list;
    }
    public void print(int curr, int n, List<Integer> list){
        if(curr > n){
            return;
        }
        list.add(curr);
        for(int i=0;i<=9;i++){
            print(curr*10+i, n, list);
        }
    }
}
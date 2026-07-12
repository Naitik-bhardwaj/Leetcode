class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        for(int n : copy){
            if(!hm.containsKey(n)){
                hm.put(n, rank);
                rank++;
            }
        }
        int[] ans = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i] = hm.get(arr[i]);
        }
        return ans;
    }
}
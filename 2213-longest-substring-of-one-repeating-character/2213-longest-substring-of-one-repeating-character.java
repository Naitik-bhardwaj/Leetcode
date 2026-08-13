class Solution {
    static class Node{
        int pref;
        int suff;
        int maxLen;
        char leftChar;
        char rightChar;
        Node(int pref, int suff, int maxLen, char leftChar, char rightChar){
            this.pref = pref;
            this.suff = suff;
            this.maxLen = maxLen;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }
    int n ;
    Node[] segmentTree;
    void buildSegmentTree(int i, int l, int r, String s){
        if(l == r){
            segmentTree[i] = new Node(1, 1, 1, s.charAt(l), s.charAt(l));
            return;
        }
        int mid = l+ (r-l)/2;
        buildSegmentTree(2*i+1, l, mid, s);
        buildSegmentTree(2*i+2, mid+1, r, s);
        segmentTree[i] = merge(segmentTree[2*i+1], segmentTree[2*i+2], mid-l+1, r-mid);
    }
    Node merge(Node L, Node R, int leftLen, int rightLen) {
        Node res = new Node(0, 0, 0,L.leftChar,R.rightChar);
        res.leftChar  = L.leftChar;
        res.rightChar = R.rightChar;
        res.pref = L.pref;
        if (L.pref == leftLen && L.rightChar == R.leftChar) {
            res.pref = L.pref + R.pref;
        }

        res.suff = R.suff;
        if (R.suff == rightLen && L.rightChar == R.leftChar) {
            res.suff = R.suff + L.suff;
        }

        res.maxLen = Math.max(L.maxLen, R.maxLen);
        if (L.rightChar == R.leftChar) {
            res.maxLen = Math.max(res.maxLen, L.suff + R.pref);
        }

        return res;
    }
    void update(int i, int l, int r,int pos, char ch ){
        if(l == r){
            segmentTree[i] = new Node(1, 1, 1, ch, ch);
            return;
        }
        int mid  = l + (r - l)/2;
        if(pos <= mid){
            update(2*i+1, l, mid, pos, ch);
        } else{
            update(2*i+2, mid+1, r, pos, ch);
        }
        segmentTree[i] = merge(segmentTree[2*i+1], segmentTree[2*i+2],mid-l+1,  r-mid);
    }
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        segmentTree = new Node[4*n];
        buildSegmentTree(0, 0, n-1, s);
        int k = queryIndices.length;
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            int pos = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            update(0, 0, n-1, pos, ch);
            result[i] = segmentTree[0].maxLen;
        }
        return result;
    }
}
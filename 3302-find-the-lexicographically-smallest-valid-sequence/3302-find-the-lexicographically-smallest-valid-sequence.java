class Solution {
    public int[] validSequence(String word1, String word2) {
        int n =word1.length();
        int m= word2.length();
        int[] rightMatchLength = new int[n];
        int i=n-1, j = m-1;
        int rightMatched = 0;
        while(i >= 0){
            if(j>=0 && word1.charAt(i) == word2.charAt(j)){
                rightMatched++;
                j--;
            }
            rightMatchLength[i] = rightMatched;
            i--;
        }
        int[] seq = new int[m];
        boolean changePower = true;
        i = 0; j = 0;
        int k=0;
        while(i < n && j<m){
            if(word1.charAt(i) == word2.charAt(j)){
                seq[k++] = i;
                j++;
            }
            else if(changePower == true && (i+1)<n && rightMatchLength[i+1]>=m-j-1){
                seq[k++] = i;
                j++;
                changePower = false;
            }
            i++;

        }
        return (j==m) ?seq : new int[0] ;
    }
}
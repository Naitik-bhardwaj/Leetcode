class Solution {
    private int findAns(int n){
        String s = String.valueOf(n);
        if(s.length() < 3) return 0;
        int count = 0;
        for(int i=1;i<s.length()-1;i++){
            int left = s.charAt(i-1) - '0';
            int curr = s.charAt(i) - '0';
            int right = s.charAt(i+1) - '0';
            
            if(left < curr && curr > right) count++;
            else if(left > curr && right>curr) count++;
        }

        return count;

    }
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i=num1;i<=num2;i++){
            ans += findAns(i);
        }
        return ans;

    }
}
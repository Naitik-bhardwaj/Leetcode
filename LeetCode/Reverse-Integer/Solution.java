1class Solution {
2    public int reverse(int x) {
3        int rev = 0;
4        while(x != 0) {
5            int temp = x % 10;
6            x = x / 10;
7            if(rev > 0 && rev > (Integer.MAX_VALUE - temp) / 10 ||
8               rev < 0 && rev < (Integer.MIN_VALUE - temp) / 10) {
9                return 0;
10            }
11            rev = rev * 10 + temp;
12        }
13    return rev;
14    }
15}
1
2class Solution {
3    public int myAtoi(String s) {
4        if(s==null) {
5            return 0;
6        }
7        s=s.trim();
8        
9        if(s.length()==0) {
10            return 0;
11        }
12        int sign = +1;
13        long ans = 0;
14        if(s.charAt(0) == '-') {
15            sign = -1;
16        }
17        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
18		
19        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
20		
21        while(i < s.length()) {
22            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) {
23                break;
24            }
25            ans = ans * 10 + s.charAt(i)-'0';
26            if(sign == -1 && -1*ans < MIN) {
27                return MIN;
28            }
29            if(sign == 1 && ans > MAX) {
30                return MAX;
31            }
32            i++;
33        }
34        
35        return (int)(sign*ans);
36    }
37}
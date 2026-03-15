1class Solution {
2    public int getVal(char ch) {
3        switch(ch) {
4            case 'I' : return 1;
5            case 'V' : return 5;
6            case 'X' : return 10;
7            case 'L' : return 50;
8            case 'C' : return 100;
9            case 'D' : return 500;
10            case 'M' : return 1000;
11            default : return 0;
12
13        }
14    }
15    public int romanToInt(String s) {
16        int sum = 0;
17        for(int i=0; i<s.length(); i++) {
18            char ch1 = s.charAt(i);
19            if((i+1) < s.length() && getVal(ch1) < getVal(s.charAt(i+1))) {
20                sum = sum - getVal(ch1);
21            }
22            else{
23                sum = sum + getVal(ch1);
24            } 
25        }
26    return sum;
27    }
28}
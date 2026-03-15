1class Solution {
2    public String intToRoman(int num) {
3        String roman = "";
4        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
5        String[] romanLetter = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X","IX", "V", "IV", "I"};
6
7        for(int i=0; i<values.length; i++) {
8            while(num >= values[i]) {
9                roman = roman + romanLetter[i];
10                num = num - values[i];
11            }
12        }
13    return roman;
14    }
15}
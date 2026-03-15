1class Solution {
2    public boolean isPalindrome(int x) {
3        int n = x;
4        int rev = 0;
5        if(x==0) return true;
6        if(x>0){
7            while(n>0){
8                int rem = n%10;
9                rev = rev*10+rem;
10                n=n/10;
11            }
12            if(x==rev){
13                return true;
14            }
15        } 
16        return false;
17    }    
18}
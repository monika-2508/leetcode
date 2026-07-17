// Last updated: 7/17/2026, 2:51:44 PM
1class Solution {
2    public boolean isNumber(String s) {
3        s = s.trim();
4        
5        boolean seenDigit = false;
6        boolean seenDot = false;
7        boolean seenE = false;
8        
9        for (int i = 0; i < s.length(); i++) {
10            char ch = s.charAt(i);
11            
12            if (Character.isDigit(ch)) {
13                seenDigit = true;
14            } else if (ch == '+' || ch == '-') {
15                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
16                    return false;
17                }
18            } else if (ch == 'e' || ch == 'E') {
19                if (seenE || !seenDigit) {
20                    return false;
21                }
22                seenE = true;
23                seenDigit = false; 
24            } else if (ch == '.') {
25                if (seenDot || seenE) {
26                    return false;
27                }
28                seenDot = true;
29            } else {
30                return false;
31            }
32        }
33        
34        return seenDigit;
35    }
36}
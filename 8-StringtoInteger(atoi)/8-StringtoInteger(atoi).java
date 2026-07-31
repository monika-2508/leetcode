// Last updated: 7/31/2026, 9:04:38 AM
1class Solution {
2    public int myAtoi(String s) {
3        if (s == null || s.length() == 0) {
4            return 0;
5        }
6
7        int i = 0;
8        int n = s.length();
9
10        // 1. Skip leading whitespaces
11        while (i < n && s.charAt(i) == ' ') {
12            i++;
13        }
14
15        if (i == n) {
16            return 0;
17        }
18
19        // 2. Handle optional sign
20        int sign = 1;
21        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
22            sign = (s.charAt(i) == '-') ? -1 : 1;
23            i++;
24        }
25
26        // 3. Process digits and handle overflow/underflow
27        int result = 0;
28        while (i < n && Character.isDigit(s.charAt(i))) {
29            int digit = s.charAt(i) - '0';
30
31            // Check for potential overflow/underflow before multiplying by 10
32            if (result > Integer.MAX_VALUE / 10 || 
33               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
34                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
35            }
36
37            result = result * 10 + digit;
38            i++;
39        }
40
41        return result * sign;
42    }
43}
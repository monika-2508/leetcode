// Last updated: 8/6/2026, 9:11:18 AM
1class Solution {
2    public int romanToInt(String s) {
3        int res = 0;
4        for (int i = 0; i < s.length(); i++) {
5            int current = getValue(s.charAt(i));
6            
7            // If the next symbol has a larger value, subtract current value
8            if (i + 1 < s.length() && current < getValue(s.charAt(i + 1))) {
9                res -= current;
10            } else {
11                res += current;
12            }
13        }
14        return res;
15    }
16
17    private int getValue(char ch) {
18        switch (ch) {
19            case 'I': return 1;
20            case 'V': return 5;
21            case 'X': return 10;
22            case 'L': return 50;
23            case 'C': return 100;
24            case 'D': return 500;
25            case 'M': return 1000;
26            default: return 0;
27        }
28    }
29}
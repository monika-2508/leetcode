// Last updated: 9/21/2026, 1:28:29 PM
1class Solution {
2    public String intToRoman(int num) {
3        // Values in descending order along with their subtractive pairs
4        int[] values = {
5            1000, 900, 500, 400,
6            100, 90, 50, 40,
7            10, 9, 5, 4,
8            1
9        };
10        
11        String[] symbols = {
12            "M", "CM", "D", "CD",
13            "C", "XC", "L", "XL",
14            "X", "IX", "V", "IV",
15            "I"
16        };
17        
18        StringBuilder sb = new StringBuilder();
19        
20        for (int i = 0; i < values.length; i++) {
21            while (num >= values[i]) {
22                sb.append(symbols[i]);
23                num -= values[i];
24            }
25        }
26        
27        return sb.toString();
28    }
29}
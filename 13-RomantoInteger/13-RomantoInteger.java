// Last updated: 9/21/2026, 1:31:23 PM
1class Solution {
2    public String multiply(String num1, String num2) {
3        if ("0".equals(num1) || "0".equals(num2)) {
4            return "0";
5        }
6
7        int m = num1.length();
8        int n = num2.length();
9        int[] pos = new int[m + n];
10
11        // Multiply digits from right to left
12        for (int i = m - 1; i >= 0; i--) {
13            int d1 = num1.charAt(i) - '0';
14            for (int j = n - 1; j >= 0; j--) {
15                int d2 = num2.charAt(j) - '0';
16                int mul = d1 * d2;
17
18                int p1 = i + j;
19                int p2 = i + j + 1;
20                int sum = mul + pos[p2];
21
22                pos[p2] = sum % 10;
23                pos[p1] += sum / 10;
24            }
25        }
26
27        // Build string, omitting leading zeros
28        StringBuilder sb = new StringBuilder();
29        for (int p : pos) {
30            if (!(sb.length() == 0 && p == 0)) {
31                sb.append(p);
32            }
33        }
34
35        return sb.length() == 0 ? "0" : sb.toString();
36    }
37}
// Last updated: 8/11/2026, 8:56:35 AM
1class Solution {
2    public String convert(String s, int numRows) {
3        if (numRows == 1 || s.length() <= numRows) {
4            return s;
5        }
6
7        StringBuilder[] rows = new StringBuilder[numRows];
8        for (int i = 0; i < numRows; i++) {
9            rows[i] = new StringBuilder();
10        }
11
12        int currentRow = 0;
13        boolean goingDown = false;
14
15        for (char c : s.toCharArray()) {
16            rows[currentRow].append(c);
17            
18            // Change direction when reaching top or bottom row
19            if (currentRow == 0 || currentRow == numRows - 1) {
20                goingDown = !goingDown;
21            }
22
23            currentRow += goingDown ? 1 : -1;
24        }
25
26        StringBuilder result = new StringBuilder();
27        for (StringBuilder row : rows) {
28            result.append(row);
29        }
30
31        return result.toString();
32    }
33}
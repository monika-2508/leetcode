// Last updated: 9/21/2026, 1:23:11 PM
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
4            return false;
5        }
6
7        int m = matrix.length;
8        int n = matrix[0].length;
9
10        // Start from top-right corner
11        int row = 0;
12        int col = n - 1;
13
14        while (row < m && col >= 0) {
15            if (matrix[row][col] == target) {
16                return true;
17            } else if (matrix[row][col] > target) {
18                col--; // Move left
19            } else {
20                row++; // Move down
21            }
22        }
23
24        return false;
25    }
26}
// Last updated: 9/1/2026, 8:59:27 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> getRow(int rowIndex) {
6        List<Integer> row = new ArrayList<>();
7        row.add(1);
8
9        for (int i = 1; i <= rowIndex; i++) {
10            // Update the existing values from right to left
11            for (int j = i - 1; j > 0; j--) {
12                row.set(j, row.get(j) + row.get(j - 1));
13            }
14            // Each row ends with 1
15            row.add(1);
16        }
17
18        return row;
19    }
20}
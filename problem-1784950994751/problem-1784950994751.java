// Last updated: 7/25/2026, 9:13:14 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public String getPermutation(int n, int k) {
6        List<Integer> numbers = new ArrayList<>();
7        int[] factorial = new int[n];
8        
9        // Precompute factorials and populate the list of numbers [1, 2, ..., n]
10        factorial[0] = 1;
11        for (int i = 1; i < n; i++) {
12            factorial[i] = factorial[i - 1] * i;
13            numbers.add(i);
14        }
15        numbers.add(n);
16
17        // Convert k to 0-based index
18        k = k - 1;
19
20        StringBuilder sb = new StringBuilder();
21
22        for (int i = n; i > 0; i--) {
23            int index = k / factorial[i - 1];
24            sb.append(numbers.get(index));
25            numbers.remove(index);
26            k %= factorial[i - 1];
27        }
28
29        return sb.toString();
30    }
31}
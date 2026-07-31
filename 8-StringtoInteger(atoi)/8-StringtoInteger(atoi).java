// Last updated: 7/31/2026, 9:07:57 AM
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    private Map<String, Boolean> memo = new HashMap<>();
6
7    public boolean isScramble(String s1, String s2) {
8        // Base case 1: Strings are identical
9        if (s1.equals(s2)) {
10            return true;
11        }
12
13        // Base case 2: String lengths differ (should not happen per constraints)
14        if (s1.length() != s2.length()) {
15            return false;
16        }
17
18        // Check memoization table
19        String key = s1 + "_" + s2;
20        if (memo.containsKey(key)) {
21            return memo.get(key);
22        }
23
24        // Pruning: If character counts do not match, s2 cannot be a scrambled version of s1
25        int[] count = new int[26];
26        int len = s1.length();
27        for (int i = 0; i < len; i++) {
28            count[s1.charAt(i) - 'a']++;
29            count[s2.charAt(i) - 'a']--;
30        }
31        for (int c : count) {
32            if (c != 0) {
33                memo.put(key, false);
34                return false;
35            }
36        }
37
38        // Try every possible split position i
39        for (int i = 1; i < len; i++) {
40            // Case 1: Substrings are NOT swapped
41            // s1[0...i-1] matches s2[0...i-1] AND s1[i...len-1] matches s2[i...len-1]
42            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
43                isScramble(s1.substring(i), s2.substring(i))) {
44                memo.put(key, true);
45                return true;
46            }
47
48            // Case 2: Substrings ARE swapped
49            // s1[0...i-1] matches s2[len-i...len-1] AND s1[i...len-1] matches s2[0...len-i-1]
50            if (isScramble(s1.substring(0, i), s2.substring(len - i)) &&
51                isScramble(s1.substring(i), s2.substring(0, len - i))) {
52                memo.put(key, true);
53                return true;
54            }
55        }
56
57        memo.put(key, false);
58        return false;
59    }
60}
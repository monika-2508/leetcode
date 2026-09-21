// Last updated: 9/21/2026, 1:29:38 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    private static final String[] KEYPAD = {
6        "",     // 0
7        "",     // 1
8        "abc",  // 2
9        "def",  // 3
10        "ghi",  // 4
11        "jkl",  // 5
12        "mno",  // 6
13        "pqrs", // 7
14        "tuv",  // 8
15        "wxyz"  // 9
16    };
17
18    public List<String> letterCombinations(String digits) {
19        List<String> result = new ArrayList<>();
20        if (digits == null || digits.isEmpty()) {
21            return result;
22        }
23
24        backtrack(digits, 0, new StringBuilder(), result);
25        return result;
26    }
27
28    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
29        if (index == digits.length()) {
30            result.add(current.toString());
31            return;
32        }
33
34        String letters = KEYPAD[digits.charAt(index) - '0'];
35        for (int i = 0; i < letters.length(); i++) {
36            current.append(letters.charAt(i));
37            backtrack(digits, index + 1, current, result);
38            current.deleteCharAt(current.length() - 1); // Backtrack
39        }
40    }
41}
// Last updated: 7/17/2026, 2:53:43 PM
1import java.util.Stack;
2
3class Solution {
4    public int calculate(String s) {
5        Stack<Integer> stack = new Stack<>();
6        int result = 0;
7        int number = 0;
8        int sign = 1;
9
10        for (int i = 0; i < s.length(); i++) {
11            char c = s.charAt(i);
12
13            if (Character.isDigit(c)) {
14                number = 10 * number + (c - '0');
15            } else if (c == '+') {
16                result += sign * number;
17                number = 0;
18                sign = 1;
19            } else if (c == '-') {
20                result += sign * number;
21                number = 0;
22                sign = -1;
23            } else if (c == '(') {
24                stack.push(result);
25                stack.push(sign);
26                result = 0;
27                sign = 1;
28            } else if (c == ')') {
29                result += sign * number;
30                number = 0;
31                result *= stack.pop();
32                result += stack.pop();
33            }
34        }
35
36        if (number != 0) {
37            result += sign * number;
38        }
39
40        return result;
41    }
42}
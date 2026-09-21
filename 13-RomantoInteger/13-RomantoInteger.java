// Last updated: 9/21/2026, 1:35:42 PM
1import java.util.ArrayDeque;
2import java.util.Deque;
3
4class Solution {
5    public String simplifyPath(String path) {
6        Deque<String> stack = new ArrayDeque<>();
7        String[] components = path.split("/");
8
9        for (String comp : components) {
10            // Ignore empty strings (from multiple slashes like //) and current directory '.'
11            if (comp.isEmpty() || comp.equals(".")) {
12                continue;
13            }
14            if (comp.equals("..")) {
15                // Move up one directory level if possible
16                if (!stack.isEmpty()) {
17                    stack.pollLast();
18                }
19            } else {
20                // Push valid directory name onto the stack
21                stack.offerLast(comp);
22            }
23        }
24
25        // Build canonical path
26        StringBuilder sb = new StringBuilder();
27        for (String dir : stack) {
28            sb.append("/").append(dir);
29        }
30
31        return sb.length() == 0 ? "/" : sb.toString();
32    }
33}
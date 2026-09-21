// Last updated: 9/21/2026, 1:32:12 PM
1class Solution {
2    public String countAndSay(int n) {
3        String current = "1";
4        
5        for (int i = 2; i <= n; i++) {
6            StringBuilder next = new StringBuilder();
7            int len = current.length();
8            
9            int j = 0;
10            while (j < len) {
11                char ch = current.charAt(j);
12                int count = 0;
13                
14                // Count consecutive identical characters
15                while (j < len && current.charAt(j) == ch) {
16                    count++;
17                    j++;
18                }
19                
20                // Append frequency followed by the character
21                next.append(count).append(ch);
22            }
23            
24            current = next.toString();
25        }
26        
27        return current;
28    }
29}
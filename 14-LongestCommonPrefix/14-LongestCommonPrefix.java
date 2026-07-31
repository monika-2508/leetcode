// Last updated: 7/31/2026, 9:42:40 AM
1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        if (strs == null || strs.length == 0) {
4            return "";
5        }
6
7        // Start by assuming the first string is the common prefix
8        String prefix = strs[0];
9
10        // Compare the prefix with each string in the array
11        for (int i = 1; i < strs.length; i++) {
12            // Trim the prefix until strs[i] starts with it
13            while (strs[i].indexOf(prefix) != 0) {
14                prefix = prefix.substring(0, prefix.length() - 1);
15                
16                if (prefix.isEmpty()) {
17                    return "";
18                }
19            }
20        }
21
22        return prefix;
23    }
24}
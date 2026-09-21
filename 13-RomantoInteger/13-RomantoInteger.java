// Last updated: 9/21/2026, 1:33:05 PM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.HashMap;
4import java.util.List;
5import java.util.Map;
6
7class Solution {
8    public List<List<String>> groupAnagrams(String[] strs) {
9        if (strs == null || strs.length == 0) {
10            return new ArrayList<>();
11        }
12
13        Map<String, List<String>> map = new HashMap<>();
14
15        for (String s : strs) {
16            // Sort the characters of each string to use as the map key
17            char[] chars = s.toCharArray();
18            Arrays.sort(chars);
19            String key = String.valueOf(chars);
20
21            map.putIfAbsent(key, new ArrayList<>());
22            map.get(key).add(s);
23        }
24
25        return new ArrayList<>(map.values());
26    }
27}
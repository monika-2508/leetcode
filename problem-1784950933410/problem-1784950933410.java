// Last updated: 7/25/2026, 9:12:13 AM
1import java.util.ArrayList;
2import java.util.HashMap;
3import java.util.List;
4import java.util.Map;
5
6class Solution {
7    public List<Integer> findSubstring(String s, String[] words) {
8        List<Integer> result = new ArrayList<>();
9        if (s == null || s.length() == 0 || words == null || words.length == 0) {
10            return result;
11        }
12
13        int wordLen = words[0].length();
14        int totalWords = words.length;
15        int totalLen = wordLen * totalWords;
16
17        if (s.length() < totalLen) {
18            return result;
19        }
20
21        // Count frequency of each word in the input array
22        Map<String, Integer> wordCounts = new HashMap<>();
23        for (String word : words) {
24            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
25        }
26
27        // Run sliding window for each possible starting index shift (0 to wordLen - 1)
28        for (int i = 0; i < wordLen; i++) {
29            Map<String, Integer> currentCounts = new HashMap<>();
30            int left = i;
31            int count = 0;
32
33            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
34                String sub = s.substring(right, right + wordLen);
35
36                if (wordCounts.containsKey(sub)) {
37                    currentCounts.put(sub, currentCounts.getOrDefault(sub, 0) + 1);
38                    count++;
39
40                    // If a word appears more times than expected, shrink window from left
41                    while (currentCounts.get(sub) > wordCounts.get(sub)) {
42                        String leftWord = s.substring(left, left + wordLen);
43                        currentCounts.put(leftWord, currentCounts.get(leftWord) - 1);
44                        count--;
45                        left += wordLen;
46                    }
47
48                    // If valid window contains all words
49                    if (count == totalWords) {
50                        result.add(left);
51                    }
52                } else {
53                    // Invalid word found: reset window
54                    currentCounts.clear();
55                    count = 0;
56                    left = right + wordLen;
57                }
58            }
59        }
60
61        return result;
62    }
63}
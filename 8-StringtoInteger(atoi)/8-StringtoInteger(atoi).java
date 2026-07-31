// Last updated: 7/31/2026, 9:06:48 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> fullJustify(String[] words, int maxWidth) {
6        List<String> result = new ArrayList<>();
7        int i = 0;
8        int n = words.length;
9
10        while (i < n) {
11            int j = i + 1;
12            int lineLength = words[i].length();
13
14            // Determine how many words can fit into the current line
15            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
16                lineLength += 1 + words[j].length();
17                j++;
18            }
19
20            int numOfWords = j - i;
21            StringBuilder sb = new StringBuilder();
22
23            // Case 1: Last line or a line with only one word -> Left-justified
24            if (j == n || numOfWords == 1) {
25                for (int k = i; k < j; k++) {
26                    sb.append(words[k]);
27                    if (k < j - 1) {
28                        sb.append(" ");
29                    }
30                }
31                // Pad remaining spaces to the right
32                while (sb.length() < maxWidth) {
33                    sb.append(" ");
34                }
35            } 
36            // Case 2: Middle line with multiple words -> Fully (left and right) justified
37            else {
38                int totalWordChars = 0;
39                for (int k = i; k < j; k++) {
40                    totalWordChars += words[k].length();
41                }
42
43                int totalSpaces = maxWidth - totalWordChars;
44                int spacesBetweenSlots = totalSpaces / (numOfWords - 1);
45                int extraSpaces = totalSpaces % (numOfWords - 1);
46
47                for (int k = i; k < j; k++) {
48                    sb.append(words[k]);
49                    if (k < j - 1) {
50                        // Base spaces for each slot
51                        int spacesToApply = spacesBetweenSlots + (k - i < extraSpaces ? 1 : 0);
52                        for (int s = 0; s < spacesToApply; s++) {
53                            sb.append(" ");
54                        }
55                    }
56                }
57            }
58
59            result.add(sb.toString());
60            i = j; // Move to the next line's starting word
61        }
62
63        return result;
64    }
65}
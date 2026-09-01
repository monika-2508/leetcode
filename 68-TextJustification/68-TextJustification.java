// Last updated: 9/1/2026, 9:28:01 AM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();

            // Determine how many words can fit into the current line
            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int numOfWords = j - i;
            StringBuilder sb = new StringBuilder();

            // Case 1: Last line or a line with only one word -> Left-justified
            if (j == n || numOfWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                // Pad remaining spaces to the right
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            // Case 2: Middle line with multiple words -> Fully (left and right) justified
            else {
                int totalWordChars = 0;
                for (int k = i; k < j; k++) {
                    totalWordChars += words[k].length();
                }

                int totalSpaces = maxWidth - totalWordChars;
                int spacesBetweenSlots = totalSpaces / (numOfWords - 1);
                int extraSpaces = totalSpaces % (numOfWords - 1);

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        // Base spaces for each slot
                        int spacesToApply = spacesBetweenSlots + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j; // Move to the next line's starting word
        }

        return result;
    }
}
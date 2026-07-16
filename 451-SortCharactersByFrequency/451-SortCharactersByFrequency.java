// Last updated: 7/16/2026, 4:11:58 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        // Step 1: Count frequencies using an ASCII array
        // (Covers numbers, uppercase, and lowercase letters safely)
        int[] freqMap = new int[128];
        for (char c : s.toCharArray()) {
            freqMap[c]++;
        }

        // Step 2: Create buckets where index = frequency
        int maxFreq = s.length();
        List<Character>[] buckets = new List[maxFreq + 1];

        for (int i = 0; i < 128; i++) {
            int freq = freqMap[i];
            if (freq > 0) {
                if (buckets[freq] == null) {
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add((char) i);
            }
        }

        // Step 3: Build the string from highest frequency to lowest
        StringBuilder sb = new StringBuilder();
        for (int freq = maxFreq; freq > 0; freq--) {
            if (buckets[freq] != null) {
                for (char c : buckets[freq]) {
                    // Append the character 'freq' times
                    for (int i = 0; i < freq; i++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
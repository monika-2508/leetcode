// Last updated: 9/1/2026, 9:28:20 AM
class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < s.length()) {
            // Case 1: Match single character or '?' wildcard
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } 
            // Case 2: Found '*' wildcard, record position and try matching 0 characters first
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++;
            } 
            // Case 3: Last seen character was '*', backtrack and match 1 more character in s
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                sTmpIdx++;
                sIdx = sTmpIdx;
            } 
            // Case 4: No match and no '*' to backtrack to
            else {
                return false;
            }
        }

        // Check for remaining trailing '*' in pattern
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == p.length();
    }
}
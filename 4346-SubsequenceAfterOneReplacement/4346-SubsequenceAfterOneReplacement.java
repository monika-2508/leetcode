// Last updated: 7/16/2026, 4:09:05 PM
class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        if (n > m) return false;
        
        // pref[i] stores the earliest ending index in t for matching s[0...i]
        int[] pref = new int[n];
        int tIdx = 0;
        for (int i = 0; i < n; i++) {
            while (tIdx < m && t.charAt(tIdx) != s.charAt(i)) {
                tIdx++;
            }
            if (tIdx < m) {
                pref[i] = tIdx;
                tIdx++; // move forward in t for the next character
            } else {
                // If we can't even match up to index i, fill the remaining with m
                while (i < n) {
                    pref[i++] = m;
                }
            }
        }
        
        // If s is already a subsequence of t without any replacement
        if (pref[n - 1] < m) return true;
        
        // suff[i] stores the latest starting index in t for matching s[i...n-1]
        int[] suff = new int[n];
        tIdx = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (tIdx >= 0 && t.charAt(tIdx) != s.charAt(i)) {
                tIdx--;
            }
            if (tIdx >= 0) {
                suff[i] = tIdx;
                tIdx--; // move backward in t for the next character
            } else {
                // If we can't match the suffix, fill remaining with -1
                while (i >= 0) {
                    suff[i--] = -1;
                }
            }
        }
        
        // Try replacing each index i in string s
        for (int i = 0; i < n; i++) {
            // Find boundaries in t for s[0...i-1] and s[i+1...n-1]
            int leftBound = (i == 0) ? -1 : pref[i - 1];
            int rightBound = (i == n - 1) ? m : suff[i + 1];
            
            // Both prefix and suffix must be validly matchable
            if (leftBound < m && rightBound >= 0) {
                // There must be at least one character gap in t between leftBound and rightBound
                if (rightBound - leftBound > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
// Last updated: 7/16/2026, 4:12:34 PM
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

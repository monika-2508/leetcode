// Last updated: 9/1/2026, 9:29:01 AM
class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            
            // If the next symbol has a larger value, subtract current value
            if (i + 1 < s.length() && current < getValue(s.charAt(i + 1))) {
                res -= current;
            } else {
                res += current;
            }
        }
        return res;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
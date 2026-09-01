// Last updated: 9/1/2026, 9:26:46 AM
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust for 1-based indexing (0 -> 'A', 25 -> 'Z')
            char remainder = (char) ('A' + (columnNumber % 26));
            result.append(remainder);
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}
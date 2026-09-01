// Last updated: 9/1/2026, 9:28:09 AM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n];
        
        // Precompute factorials and populate the list of numbers [1, 2, ..., n]
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }
        numbers.add(n);

        // Convert k to 0-based index
        k = k - 1;

        StringBuilder sb = new StringBuilder();

        for (int i = n; i > 0; i--) {
            int index = k / factorial[i - 1];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial[i - 1];
        }

        return sb.toString();
    }
}
// Last updated: 7/16/2026, 4:12:21 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.count = new int[n];
        
        // Pair each number with its original index to track counts correctly
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Perform modified merge sort
        mergeSort(pairs, 0, n - 1);

        // Convert the primitive array result into the required List format
        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int[][] pairs, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(pairs, left, mid);
        mergeSort(pairs, mid + 1, right);
        merge(pairs, left, mid, right);
    }

    private void merge(int[][] pairs, int left, int mid, int right) {
        int[][] temp = new int[right - left + 1][2];
        int i = left;      // Pointer for the left subarray
        int j = mid + 1;   // Pointer for the right subarray
        int k = 0;         // Pointer for the temp array
        int rightSmallerCount = 0; // Tracks elements pulled from the right subarray

        while (i <= mid && j <= right) {
            // If the element in the right subarray is strictly smaller
            if (pairs[j][0] < pairs[i][0]) {
                rightSmallerCount++;
                temp[k++] = pairs[j++];
            } else {
                // When moving an element from the left subarray, 
                // add the accumulated count of smaller elements seen from the right so far
                count[pairs[i][1]] += rightSmallerCount;
                temp[k++] = pairs[i++];
            }
        }

        // Clean up remaining elements in the left subarray
        while (i <= mid) {
            count[pairs[i][1]] += rightSmallerCount;
            temp[k++] = pairs[i++];
        }

        // Clean up remaining elements in the right subarray
        while (j <= right) {
            temp[k++] = pairs[j++];
        }

        // Copy back the sorted chunk into the original array
        System.arraycopy(temp, 0, pairs, left, temp.length);
    }
}
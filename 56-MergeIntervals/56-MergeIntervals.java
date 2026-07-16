// Last updated: 7/16/2026, 4:13:39 PM
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Base case: if there's only one or no interval, return as is
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a linked list to dynamically handle the merged results
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // If the list of merged intervals is empty 
            // OR if the current interval does not overlap with the previous one
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
// Last updated: 7/16/2026, 4:09:16 PM
import java.util.PriorityQueue;

class Solution {
    // Sparse tables for O(1) Range Maximum and Range Minimum Queries
    private int[][] stMax;
    private int[][] stMin;
    private int[] logTable;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        // 1. Precompute log values for O(1) RMQ
        logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }
        
        int maxLog = logTable[n] + 1;
        stMax = new int[n][maxLog];
        stMin = new int[n][maxLog];
        
        // 2. Initialize Sparse Tables
        for (int i = 0; i < n; i++) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }
        
        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[i + (1 << (j - 1))][j - 1]);
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[i + (1 << (j - 1))][j - 1]);
            }
        }
        
        // 3. Max-Heap to track the largest subarray values
        // Element format: long[] {value, left_idx, right_idx}
        PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        
        // Initialize heap with the maximum span (r = n - 1) for each starting point l
        for (int l = 0; l < n; l++) {
            long val = queryValue(l, n - 1);
            maxHeap.offer(new long[]{val, l, n - 1});
        }
        
        long totalValue = 0;
        
        // 4. Extract the top k maximum distinct subarrays
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break;
            
            long[] curr = maxHeap.poll();
            long val = curr[0];
            int l = (int) curr[1];
            int r = (int) curr[2];
            
            totalValue += val;
            
            // If there's still a valid smaller subarray to look at, push it
            if (r > l) {
                long nextVal = queryValue(l, r - 1);
                maxHeap.offer(new long[]{nextVal, l, r - 1});
            }
        }
        
        return totalValue;
    }
    
    // Helper to get max - min in O(1)
    private long queryValue(int L, int R) {
        int j = logTable[R - L + 1];
        int maxVal = Math.max(stMax[L][j], stMax[R - (1 << j) + 1][j]);
        int minVal = Math.min(stMin[L][j], stMin[R - (1 << j) + 1][j]);
        return (long) maxVal - minVal;
    }
}
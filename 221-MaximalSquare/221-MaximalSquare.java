// Last updated: 9/21/2026, 1:21:28 PM
1import java.util.ArrayDeque;
2import java.util.Deque;
3
4class Solution {
5    public int[] maxSlidingWindow(int[] nums, int k) {
6        if (nums == null || k <= 0) return new int[0];
7        
8        int n = nums.length;
9        int[] result = new int[n - k + 1];
10        // Deque stores indices; elements in deque maintain monotonically decreasing order
11        Deque<Integer> deque = new ArrayDeque<>();
12
13        for (int i = 0; i < n; i++) {
14            // 1. Remove indices that are outside the current window [i - k + 1, i]
15            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
16                deque.pollFirst();
17            }
18
19            // 2. Maintain decreasing order: remove smaller elements from the back
20            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
21                deque.pollLast();
22            }
23
24            // 3. Add current element index to the back
25            deque.offerLast(i);
26
27            // 4. The front of deque is the maximum of the current window
28            if (i >= k - 1) {
29                result[i - k + 1] = nums[deque.peekFirst()];
30            }
31        }
32
33        return result;
34    }
35}
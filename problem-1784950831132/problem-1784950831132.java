// Last updated: 7/25/2026, 9:10:31 AM
1import java.util.PriorityQueue;
2
3class Solution {
4    public ListNode mergeKLists(ListNode[] lists) {
5        if (lists == null || lists.length == 0) {
6            return null;
7        }
8
9        // Min-heap to store the head nodes of each linked list sorted by value
10        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
11
12        // Add the head of each non-empty linked list to the heap
13        for (ListNode node : lists) {
14            if (node != null) {
15                minHeap.add(node);
16            }
17        }
18
19        ListNode dummy = new ListNode(0);
20        ListNode current = dummy;
21
22        // Process nodes until the min-heap is empty
23        while (!minHeap.isEmpty()) {
24            ListNode smallest = minHeap.poll();
25            current.next = smallest;
26            current = current.next;
27
28            // If the extracted node has a next node, add it to the heap
29            if (smallest.next != null) {
30                minHeap.add(smallest.next);
31            }
32        }
33
34        return dummy.next;
35    }
36}
// Last updated: 8/6/2026, 10:06:43 AM
1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public boolean hasCycle(ListNode head) {
14        if (head == null || head.next == null) {
15            return false;
16        }
17
18        ListNode slow = head;
19        ListNode fast = head;
20
21        while (fast != null && fast.next != null) {
22            slow = slow.next;          // Move slow pointer by 1 step
23            fast = fast.next.next;     // Move fast pointer by 2 steps
24
25            // If fast and slow meet, a cycle exists
26            if (slow == fast) {
27                return true;
28            }
29        }
30
31        return false;
32    }
33}
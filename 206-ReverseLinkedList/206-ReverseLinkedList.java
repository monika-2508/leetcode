// Last updated: 9/1/2026, 9:22:10 AM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseList(ListNode head) {
13        ListNode prev = null;
14        ListNode curr = head;
15
16        while (curr != null) {
17            ListNode nextTemp = curr.next; // Store next node
18            curr.next = prev;              // Reverse current pointer
19            prev = curr;                   // Move prev forward
20            curr = nextTemp;               // Move curr forward
21        }
22
23        return prev; // New head of reversed list
24    }
25}
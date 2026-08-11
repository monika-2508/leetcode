// Last updated: 8/11/2026, 8:51:51 AM
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
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13        ListNode dummyHead = new ListNode(0);
14        ListNode current = dummyHead;
15        int carry = 0;
16
17        while (l1 != null || l2 != null || carry != 0) {
18            int val1 = (l1 != null) ? l1.val : 0;
19            int val2 = (l2 != null) ? l2.val : 0;
20
21            int sum = val1 + val2 + carry;
22            carry = sum / 10;
23
24            current.next = new ListNode(sum % 10);
25            current = current.next;
26
27            if (l1 != null) l1 = l1.next;
28            if (l2 != null) l2 = l2.next;
29        }
30
31        return dummyHead.next;
32    }
33}
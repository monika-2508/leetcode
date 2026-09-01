// Last updated: 9/1/2026, 9:06:37 AM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
14        if (headA == null || headB == null) return null;
15
16        ListNode ptrA = headA;
17        ListNode ptrB = headB;
18
19        while (ptrA != ptrB) {
20            // Move to next node or switch to the head of the opposite list
21            ptrA = (ptrA == null) ? headB : ptrA.next;
22            ptrB = (ptrB == null) ? headA : ptrB.next;
23        }
24
25        return ptrA; // Either the intersection node or null
26    }
27}
// Last updated: 7/25/2026, 9:11:18 AM
1class Solution {
2    public ListNode reverseKGroup(ListNode head, int k) {
3        if (head == null || k == 1) {
4            return head;
5        }
6
7        ListNode dummy = new ListNode(0);
8        dummy.next = head;
9        ListNode groupPrev = dummy;
10
11        while (true) {
12            // Find the k-th node from groupPrev
13            ListNode kth = getKthNode(groupPrev, k);
14            if (kth == null) {
15                break; // Fewer than k nodes remaining, stop reversing
16            }
17
18            ListNode groupNext = kth.next;
19
20            // Reverse the current k-group
21            ListNode prev = kth.next;
22            ListNode curr = groupPrev.next;
23
24            while (curr != groupNext) {
25                ListNode nextTemp = curr.next;
26                curr.next = prev;
27                prev = curr;
28                curr = nextTemp;
29            }
30
31            // Connect groupPrev to the new head of the reversed group
32            ListNode temp = groupPrev.next;
33            groupPrev.next = kth;
34            groupPrev = temp;
35        }
36
37        return dummy.next;
38    }
39
40    private ListNode getKthNode(ListNode curr, int k) {
41        while (curr != null && k > 0) {
42            curr = curr.next;
43            k--;
44        }
45        return curr;
46    }
47}
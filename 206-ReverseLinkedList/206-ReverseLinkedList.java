// Last updated: 9/1/2026, 9:26:11 AM
1class Solution {
2    public boolean isHappy(int n) {
3        int slow = n;
4        int fast = getNext(n);
5
6        while (fast != 1 && slow != fast) {
7            slow = getNext(slow);
8            fast = getNext(getNext(fast));
9        }
10
11        return fast == 1;
12    }
13
14    private int getNext(int n) {
15        int sum = 0;
16        while (n > 0) {
17            int digit = n % 10;
18            sum += digit * digit;
19            n /= 10;
20        }
21        return sum;
22    }
23}
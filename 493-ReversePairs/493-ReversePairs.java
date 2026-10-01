// Last updated: 10/1/2026, 9:51:37 AM
1class Solution {
2    public int reversePairs(int[] nums) {
3        if (nums == null || nums.length < 2) {
4            return 0;
5        }
6        return mergeSort(nums, 0, nums.length - 1);
7    }
8
9    private int mergeSort(int[] nums, int left, int right) {
10        if (left >= right) {
11            return 0;
12        }
13
14        int mid = left + (right - left) / 2;
15        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
16
17        // Count valid reverse pairs across both halves
18        int j = mid + 1;
19        for (int i = left; i <= mid; i++) {
20            while (j <= right && (long) nums[i] > 2L * nums[j]) {
21                j++;
22            }
23            count += (j - (mid + 1));
24        }
25
26        // Merge the two sorted halves
27        merge(nums, left, mid, right);
28
29        return count;
30    }
31
32    private void merge(int[] nums, int left, int mid, int right) {
33        int[] temp = new int[right - left + 1];
34        int p1 = left;
35        int p2 = mid + 1;
36        int k = 0;
37
38        while (p1 <= mid && p2 <= right) {
39            if (nums[p1] <= nums[p2]) {
40                temp[k++] = nums[p1++];
41            } else {
42                temp[k++] = nums[p2++];
43            }
44        }
45
46        while (p1 <= mid) {
47            temp[k++] = nums[p1++];
48        }
49
50        while (p2 <= right) {
51            temp[k++] = nums[p2++];
52        }
53
54        System.arraycopy(temp, 0, nums, left, temp.length);
55    }
56}
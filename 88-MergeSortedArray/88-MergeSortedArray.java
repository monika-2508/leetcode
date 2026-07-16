// Last updated: 7/16/2026, 4:13:25 PM
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the ends of valid elements in nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // Pointer for the last position of the merged array
        int p = m + n - 1;

        // Compare elements from the back and move the larger one to the end
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If there are remaining elements in nums2, copy them over
        // (If elements remain in nums1, they are already in their correct sorted places)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
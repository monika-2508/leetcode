// Last updated: 7/16/2026, 4:10:39 PM
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = peakIndexInMountainArray(mountainArr);
        
        int firstTry = orderAgnosticBS(mountainArr, target, 0, peak, true);
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBS(mountainArr, target, peak + 1, n - 1, false);
    }
    private int peakIndexInMountainArray(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // Order-agnostic binary search for MountainArray
    private int orderAgnosticBS(MountainArray mountainArr, int target, int start, int end, boolean asc) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int val = mountainArr.get(mid);

            if (val == target) {
                return mid;
            }

            if (asc) {
                if (target < val) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > val) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

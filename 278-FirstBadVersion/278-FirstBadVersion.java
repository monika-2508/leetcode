// Last updated: 7/16/2026, 4:12:26 PM
/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        
        while (low < high) {
            // Avoids integer overflow compared to (low + high) / 2
            int mid = low + (high - low) / 2;
            
            if (isBadVersion(mid)) {
                // mid could be the first bad version, or the first bad one is to the left
                high = mid; 
            } else {
                // mid is good, so the first bad version must strictly be to the right
                low = mid + 1; 
            }
        }
        
        // When low == high, they have converged onto the first bad version
        return low;
    }
}
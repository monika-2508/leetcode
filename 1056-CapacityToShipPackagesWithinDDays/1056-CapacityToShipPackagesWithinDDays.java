// Last updated: 7/16/2026, 4:10:59 PM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        // Find the range boundaries
        for (int w : weights) {
            low = Math.max(low, w); // Max weight of a single package
            high += w;              // Sum of all weights
        }
        
        // Binary search for the lowest valid capacity
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canShipWithCapacity(weights, days, mid)) {
                high = mid; // Try to find a smaller feasible capacity
            } else {
                low = mid + 1; // Increase capacity because 'mid' is too small
            }
        }
        
        return low;
    }
    
    // Helper function to check if a specific capacity can finish the job in 'days'
    private boolean canShipWithCapacity(int[] weights, int days, int maxCapacity) {
        int requiredDays = 1;
        int currentWeightSum = 0;
        
        for (int w : weights) {
            if (currentWeightSum + w > maxCapacity) {
                requiredDays++; // Move to the next day
                currentWeightSum = 0;
            }
            currentWeightSum += w;
        }
        
        return requiredDays <= days;
    }
}
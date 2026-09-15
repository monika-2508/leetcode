// Last updated: 9/15/2026, 9:21:30 AM
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
       return (arrivalTime+ delayedTime) %24;
    }
}
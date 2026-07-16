// Last updated: 7/16/2026, 4:09:29 PM
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
       return (arrivalTime+ delayedTime) %24;
    }
}
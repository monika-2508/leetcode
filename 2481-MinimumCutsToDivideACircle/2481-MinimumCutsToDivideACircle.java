// Last updated: 9/15/2026, 9:22:13 AM
class Solution {
    public int numberOfCuts(int n) {
        if(n==1) return 0;
        if(n%2 == 0) return n/2;
        else return n;
    }
}
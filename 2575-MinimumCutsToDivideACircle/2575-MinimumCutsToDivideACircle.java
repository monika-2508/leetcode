// Last updated: 7/16/2026, 4:09:34 PM
class Solution {
    public int numberOfCuts(int n) {
        if(n==1) return 0;
        if(n%2 == 0) return n/2;
        else return n;
    }
}
// Last updated: 7/16/2026, 4:09:07 PM
class Solution {
    public boolean checkGoodInteger(int n) {
        int digitsum = 0;
        int squaresum = 0;
        while(n>0){
            int digit = n%10;
            digitsum+=digit;
            squaresum+=digit*digit;
            n/=10;
        }
        return (squaresum-digitsum)>=50;
    }
}
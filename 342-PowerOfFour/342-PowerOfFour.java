// Last updated: 7/16/2026, 4:12:17 PM
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) 
        return false;
        if(n==1) 
        return true;
        while(n%4==0)
        n/=4;
        if(n==1) 
        return true;
        else 
        return false;

    }
}
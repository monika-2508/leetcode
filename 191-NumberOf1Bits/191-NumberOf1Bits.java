// Last updated: 7/16/2026, 4:12:44 PM
class Solution {
    public int hammingWeight(int n) {
       int  count=0;
        while(n!=0){
            n=n&n-1;
            count++;
        }
        return count;
    }
}
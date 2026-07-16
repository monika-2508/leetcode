// Last updated: 7/16/2026, 4:13:32 PM
class Solution {
    public int climbStairs(int n) {
         if(n<=2) return n;
         int a=1,b=2;
         for(int i=3;i<=n;i++){
            b=a+b;
            a=b-a;
         }
         return b;
    }
}
// Last updated: 7/16/2026, 4:11:03 PM
class Solution {
    public int fib(int n) {
        int a=0;
        int b=1; 
        if (n==0) return 0;
        for(int i=2;i<=n;i++){
            int t=b;
            b=a+b;
            a=t;
        }
        return b;
    }
}
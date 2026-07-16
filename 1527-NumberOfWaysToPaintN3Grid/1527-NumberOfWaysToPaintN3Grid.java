// Last updated: 7/16/2026, 4:10:03 PM
class Solution {
    public int numOfWays(int n) {
        int mod = 1000000007;
        long a = 6,b=6;
        for(int i = 2;i<=n;i++){
            long a1 = (a*2+b*2)%mod;
            long b1 = (a*2+b*3)%mod;
            a = a1;
            b = b1;
        }
        return (int) ((a+b)%mod);
    }
}
// Last updated: 7/16/2026, 4:10:18 PM
class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0,product = 1 ;
        while(n>0){
            int digit = n%10;
            sum += digit;
            product *= digit;
            n/=10;
        }
        return product - sum;
    }
}
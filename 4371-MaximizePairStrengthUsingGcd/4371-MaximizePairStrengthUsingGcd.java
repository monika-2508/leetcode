// Last updated: 9/1/2026, 9:17:28 AM
class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long g = gcd(nums[i],nums[j]);
                long strength = (1L * nums[i]*nums[j])/(g*g);
                ans = Math.max(ans,strength);
            }
        }
        return ans;
    }
    private long gcd(long a,long b){
        while(b!=0){
            long temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}
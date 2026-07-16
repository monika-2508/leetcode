// Last updated: 7/16/2026, 4:09:51 PM
class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int[] person : accounts) {
            int sum = 0;
            for (int account : person) {
                sum += account;
            }
            //now we have sum of accounts of person
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}
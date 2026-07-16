// Last updated: 7/16/2026, 4:10:00 PM
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n]; 
        int j=0;
        for(int i=0;i<n;i++){
            arr[j++]=nums[i];
            arr[j++]=nums[i+n];
        }
        return arr;
    }
}
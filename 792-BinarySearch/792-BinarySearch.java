// Last updated: 7/16/2026, 4:11:16 PM
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length-1;
        int s = 0;
        int e = n;
        while(s<=e){
            int mid = s + (e-s)/2;
            if (target < nums[mid]){
                e  = mid - 1;
            }
            else if(target > nums[mid]){
                s  = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
        
    }
}
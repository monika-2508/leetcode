// Last updated: 7/16/2026, 4:11:12 PM
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0,end = arr.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            else{
                start = mid +1;
            }
        }
        return start;
    }
}
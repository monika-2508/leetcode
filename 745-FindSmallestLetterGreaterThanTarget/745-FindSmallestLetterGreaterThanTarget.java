// Last updated: 7/16/2026, 4:11:19 PM
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0,end = letters.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < letters[mid]){
                    end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
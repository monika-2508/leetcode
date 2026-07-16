// Last updated: 7/16/2026, 4:13:13 PM
class Solution {
    public boolean isPalindrome(String s) {
        int left=0, right=s.length()-1;
        while(left<right){
        while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }
        if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
            return false;
        }
        left++;
        right--;
        }
        return true;
    }
}
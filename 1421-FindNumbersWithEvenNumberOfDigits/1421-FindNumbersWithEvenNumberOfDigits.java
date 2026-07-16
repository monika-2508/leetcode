// Last updated: 7/16/2026, 4:10:14 PM
import java.util.*;
class Solution {
    public int findNumbers(int[] nums) {
        int count =0 ;
        for(int num : nums){
            if(even(num)) count++;
        }
        return count;
    }
    static int digits2(int num){
        return (int)(Math.log10(num))+1;
    }
      static boolean even(int num) {
        int numOfDigits = digits2(num);
        return numOfDigits % 2 == 0;
    }
}
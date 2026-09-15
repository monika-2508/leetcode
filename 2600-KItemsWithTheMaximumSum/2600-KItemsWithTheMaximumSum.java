// Last updated: 9/15/2026, 9:22:08 AM
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int max =  0;
        while(k>0){
            if(numOnes>0){
                max++;
                numOnes--;
                k--;
            }
            else if(numZeros>0){
                numZeros--;
                k--;
            } 
            else{
                numNegOnes--;
                max--;
                k--;
            }
        }
        return max;
    }
}
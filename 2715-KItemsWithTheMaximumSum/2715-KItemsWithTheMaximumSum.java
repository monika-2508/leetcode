// Last updated: 7/16/2026, 4:09:30 PM
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
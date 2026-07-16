// Last updated: 7/16/2026, 4:09:45 PM
class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] year = new int[2051];
        for(int[] log :logs){
            year[log[0]]+= 1;
            year[log[1]] -= 1;
        }
        int maxval=year[1950];
        int maxy=1950;
        for(int i=1951;  i<=2050;i++){
            year[i] = year[i]+year[i-1];
            if(year[i]>maxval){
                maxval =year[i];
                maxy=i;
            }
        }
        return maxy;
    }
}
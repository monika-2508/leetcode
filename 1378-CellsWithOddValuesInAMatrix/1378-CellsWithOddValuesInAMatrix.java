// Last updated: 7/16/2026, 4:10:20 PM
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
       int[][] arr= new int[m][n];
        int c=0;
       for(int[] index : indices ){
        int row =index[0];
        int col = index[1];
        for(int j=0;j< n;j++){
            arr[row][j]++;
        }
        for(int k=0;k< m ;k++){
            arr[k][col]++;
        }
       }
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (arr[i][j]%2==1){
                    c++;
                }
            }
        }
        
       
        return c;
    }
}
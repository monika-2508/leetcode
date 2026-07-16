// Last updated: 7/16/2026, 4:10:07 PM
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m=matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            int min = matrix[i][0];
            int colInd =0;
            for(int j=0;j<n;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                    colInd = j;
                }
            }
            boolean t = true;
            for(int k=0;k<m;k++){
                if(matrix[k][colInd]>min){
                    t=false;
                    break;
                }
            }
            if(t){
                result.add(min);
            }
        }
        return result;
    }
}
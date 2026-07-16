// Last updated: 7/16/2026, 4:11:53 PM
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if(row*col != r*c) return mat;

        int[][] output = new int[r][c];
        int r_output = 0;
        int c_output = 0;
        for(int i = 0; i<row; i++){
            for(int j=0;j<col;j++){
                output[r_output][c_output] = mat[i][j];
                c_output++;
                if(c_output == c){
                    c_output=0;
                    r_output++;
                }
            }
        }
        return output;
    }
}
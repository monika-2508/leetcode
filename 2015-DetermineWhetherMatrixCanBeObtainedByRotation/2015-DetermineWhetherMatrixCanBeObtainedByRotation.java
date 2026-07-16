// Last updated: 7/16/2026, 4:09:43 PM
class Solution {
    private int[][] rotate(int[][] mat){
     int n = mat.length;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[j][n - 1 - i] = mat[i][j];
            }
        }
        return m;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int k=0;k<4;k++){
              int[][] m = new int[mat.length][mat.length];
        boolean f =true;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
               
                if (mat[i][j]!=target[i][j])
                f=false;
            } if (!f) break; 
        }
        if(f) return true;
        mat = rotate(mat);
        }
      return false;
    }
}
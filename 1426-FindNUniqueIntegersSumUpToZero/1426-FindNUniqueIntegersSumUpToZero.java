// Last updated: 7/16/2026, 4:10:12 PM
class Solution {
    public int[] sumZero(int n) {
        int[] s = new int[n];
        int id=0;
        if(n%2==1){
            s[id] =0;
            n--;
        }
        for(int i=1;i<=n/2;i++){
            s[id++]=i;
            s[id++]=-i;
        }
         
        return s;
    }
}
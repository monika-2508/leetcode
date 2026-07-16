// Last updated: 7/16/2026, 4:09:32 PM
class Solution {
    public int passThePillow(int n, int time) {
        int pos=1,dir=1;
        for(int i=0;i<time;i++){
            pos+=dir;
            if(pos==n||pos==1)dir=-dir;
        }
        return pos;
    // if (n == 1) return 1;
    // int cycle = 2 * (n - 1);
    // int t = time % cycle;
    // if (t <= n - 1) {
    //     return 1 + t;        
    // } else {
    //     return n - (t - (n - 1));  
    // }
    }
}
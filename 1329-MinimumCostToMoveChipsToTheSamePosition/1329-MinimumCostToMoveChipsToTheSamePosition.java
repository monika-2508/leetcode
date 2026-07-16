// Last updated: 7/16/2026, 4:10:21 PM
class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for(int i = 0; i<position.length;i++){
            if(position[i]%2==0) even++;
            else odd++;
        }
        return Math.min(odd,even);
    }
}
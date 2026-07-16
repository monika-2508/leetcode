// Last updated: 7/16/2026, 4:10:01 PM
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for(int i = 0;i<candies.length;i++){
            if(candies[i]>max){
                max = candies[i];
            }
        }
        List<Boolean> n = new ArrayList<>();
        for(int i = 0;i<candies.length;i++){
            candies[i] = candies[i]+extraCandies;
            if(candies[i]<max){
                n.add(false);
            }
            else{
                n.add(true);
            }
        }
        return n;
    
        
    }
}
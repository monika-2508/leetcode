// Last updated: 7/16/2026, 4:11:24 PM
class Solution {
    public boolean hasAlternatingBits(int n) {
        // String bits = Integer.toBinaryString(n);
        // for(int i = 0;i<bits.length()-1;i++){
        //     if(bits.charAt(i) == bits.charAt(i+1)) return false;
        //  }
        //   return true;
        
int x = n^(n>>1);
return (x&(x+1))==0;
    } 
    
}
//int x = n^(n>>1)
//return (x&(x+1))==0
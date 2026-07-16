// Last updated: 7/16/2026, 4:13:57 PM
class Solution {
    public boolean isPalindrome(int x) {
        int o=x;
        int s=0;
        while(x>0){
            int rem=x%10;
            x/=10;
            s=s*10+rem;
        }
        return (o==s);
    
    }
}
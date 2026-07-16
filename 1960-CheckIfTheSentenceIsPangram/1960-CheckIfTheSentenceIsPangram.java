// Last updated: 7/16/2026, 4:09:47 PM
import java.util.*;
class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> s = new HashSet<>();
        for(char c: sentence.toCharArray()){
            s.add(c);
        }
        return s.size()==26;
        
        
    }
}
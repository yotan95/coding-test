import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        int index = 0;
        
        for(int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            
            while(index > 0 && result[index - 1] < current && k > 0) {
                index--;
                k--;
            }
            
            if(index < result.length) {
                result[index++] = current;
            } else {
                k--;
            }
        }
        
        return new String(result);
    }
    
}
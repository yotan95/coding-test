import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        String blank = "";
        int point = 0;
        
        for(int i = 0 ; i < name.length() ; i++){
            blank += "A";
            char target = name.charAt(i);
            
            int up = target - 'A';
            int down = 'Z' - target +1;
            answer += Math.min(up, down);
        }
        
        int move = name.length() -1;
        
        for(int i = 0 ; i < name.length(); i++){
            int next = i+1;
            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }
            
            int right = i * 2 + (name.length() - next);
            int left = (name.length() - next) * 2 + i;
            
            move = Math.min(move, Math.min(right, left));
            
        }

        return answer + move;
    }
    
}
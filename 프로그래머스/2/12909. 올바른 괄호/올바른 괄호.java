import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '('){
                st.push(c);
            } else{
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }
        
        if(!st.isEmpty()){
            answer = false;
        }
        return answer;
    }
}
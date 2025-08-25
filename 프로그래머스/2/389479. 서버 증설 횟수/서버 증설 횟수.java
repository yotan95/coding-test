import java.util.*;
import java.io.*;

class Solution {
    
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int i = 0 ; i < players.length; i++){
            
            while(!queue.isEmpty() && queue.peek() <= i){
                queue.poll();
            }
            
            int need = players[i]/ m;
            int current = queue.size();
            
            int add = Math.max(0, need - current);
            answer += add;
            
            for(int j = 0 ; j < add; j++){
                queue.add(i+k);
            }
            
            
            
        }
        
        return answer;
    }
}
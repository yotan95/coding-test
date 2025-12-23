import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0 ; i < scoville.length; i++){
            queue.add(scoville[i]);
        }
        while(queue.size() > 1 && queue.peek() < K){
            int first = queue.poll();
            int second = queue.poll();
            
            queue.add(first + (second*2));
            answer++;
        }
        
        return queue.peek() >= K ? answer : -1;
    }
}
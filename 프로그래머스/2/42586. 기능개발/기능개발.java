import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < progresses.length; i++){
            int pro = progresses[i];
            int speed = speeds[i];
            int time = 0;
            while(pro < 100){
                pro += speed;
                
                days[i] +=1;
            }
        }
        
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int d : days){
            queue.add(d);
        }
        while(!queue.isEmpty()){
            int d = queue.poll();
            count++;
            while(!queue.isEmpty() && queue.peek() <= d){
                queue.poll();
                count++;
            }
            list.add(count);
            count = 0;
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
import java.util.*;
import java.io.*;

public class Main{
    static Integer N, target;
    static int time[];
    
    private static class Node implements Comparable<Node>{
        Integer position;
        Integer time;
        
        Node(Integer position, Integer time){
            this.position = position;
            this.time = time;
        }
        
        @Override
        public int compareTo(Node e){
            return this.time - e.time;
        }
    }
    
    public static void main(String[] args) throws IOException{
        readData();
        System.out.print(pro(N, target));
    }
    
    private static Integer pro(Integer start, Integer target){
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(new Node(start, 0));
        time[start] = 0;
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            Integer currentPosition = current.position;
            Integer currentTime = current.time;
            
            if(time[currentPosition] < currentTime) continue;
            
            if(currentPosition -1 >= 0 && time[currentPosition-1] > currentTime +1){
                time[currentPosition-1] = currentTime+1;
                queue.add(new Node(currentPosition -1, currentTime +1));
            }
            
            if(currentPosition +1 <= 100000 && time[currentPosition+1] > currentTime+1){
                time[currentPosition+1] = currentTime+1;
                queue.add(new Node(currentPosition +1, currentTime +1));
            }
            
            if(currentPosition *2 <= 100000 && time[currentPosition*2] > currentTime+1){
                time[currentPosition * 2] = currentTime +1;
                queue.add(new Node(currentPosition * 2, currentTime+1));
            }
        }
        
        return time[target];
    }
    
    private static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        target = Integer.parseInt(s[1]);
        time = new int[100001];
        
        Arrays.fill(time, Integer.MAX_VALUE);
    }
    
    
}
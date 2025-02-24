import java.util.*;
import java.io.*;

public class Main{
    
   static int n, k;
    static int[] dir;

    public static class Node implements Comparable<Node>{
        int position;
        int dir;

        Node(int position, int dir){
            this.position = position;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node d){
            return this.dir - d.dir;
        }
        
    }

    public static void main(String[] args) throws IOException{
        readData();
        pro();
        System.out.print(dir[k]);
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        dir = new int[100001];
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        Arrays.fill(dir, Integer.MAX_VALUE);
    }

    public static void pro(){
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(n, 0));
        dir[n] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            int currentPosition = node.position;
            int currentDir = node.dir;

            if(isValid(currentPosition - 1) && dir[currentPosition-1] > currentDir + 1){
                dir[currentPosition-1] = currentDir + 1;
                q.add(new Node(currentPosition - 1, currentDir+1));
            }
            if(isValid(currentPosition +1) && dir[currentPosition +1] > currentDir+1){
                dir[currentPosition+1] = currentDir+1;
                q.add(new Node(currentPosition+1, currentDir+1));
            }
            if(isValid(currentPosition*2) && dir[currentPosition*2] > currentDir+1){
                dir[currentPosition*2] = currentDir+1;
                q.add(new Node(currentPosition*2, currentDir+1));
            }
        }
    }

    public static boolean isValid(int x){
        return x >= 0 && x < 100001;
    }
    
}
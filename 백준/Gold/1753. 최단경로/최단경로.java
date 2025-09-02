import java.util.*;
import java.io.*;

public class Main{
    private static class Node implements Comparable<Node>{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node next){
            return this.weight - next.weight;
        }

    }

    static int v,e,k;
    static ArrayList<ArrayList<Node>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readData();
        pro();
        System.out.print(sb.toString());
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        k = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Node>>();

        for(int i = 0 ; i <= v; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0 ; i < e; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            graph.get(start).add(new Node(end, cost));
        }

    }

    public static void pro(){
        int[] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(new Node(k,0));

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(!graph.get(current.vertex).isEmpty()) {
                for (Node adjacent : graph.get(current.vertex)) {
                    int cost = adjacent.weight + dist[current.vertex];

                    if(cost < dist[adjacent.vertex]){
                        dist[adjacent.vertex] = cost;
                        queue.add(new Node(adjacent.vertex, cost));
                    }
                }
            }
        }
        for(int i = 1; i < dist.length; i++){
            if(dist[i] <= 10*e ){
                sb.append(dist[i]).append("\n");
            }else{
                sb.append("INF\n");
            }
        }

    }
}
import java.util.*;

class Solution {
    
    private static class Node implements Comparable<Node>{
        int vertex;
        int weight;
        
        Node(int vertex,  int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other){
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        int answer = 0;        
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<Node>());
        }
        
        for(int i = 0 ; i < road.length; i++){
            int startNode = road[i][0];
            int endNode = road[i][1];
            int time = road[i][2];
            
            graph.get(startNode).add(new Node(endNode, time));
            graph.get(endNode).add(new Node(startNode, time));
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        queue.add(new Node(1,0));
        
        while(!queue.isEmpty()){
            Node current = queue.remove();
            
            for(Node next : graph.get(current.vertex)){
                int cost = next.weight + dist[current.vertex];
                
                if(cost < dist[next.vertex]){
                    dist[next.vertex] = cost;
                    queue.add(new Node(next.vertex, cost));
                }
            }
        }
        
        for(int i = 1 ; i <= N; i++){
            if(dist[i] <= K) answer++;
        }
        

        return answer;
    }
    
}
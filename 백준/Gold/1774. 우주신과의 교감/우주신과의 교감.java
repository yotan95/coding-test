import java.util.*;
import java.io.*;

public class Main{
    static class Node {
        int num;
        double x, y;
        
        Node(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
        double distanceTo(Node other) {
            return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        double weight;
        
        Edge(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }
    }

    static int n, m;
    static Node[] nodes;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException {
        readData();
        System.out.printf("%.2f", prim());
    }

    static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new Node[n + 1]; // 1-based 인덱싱
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            nodes[i] = new Node(i, x, y);
        }

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 기존 연결 처리 (가중치 0)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, 0.0));
            graph.get(b).add(new Edge(a, 0.0));
        }
    }

    static double prim() {
        visited = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        double total = 0.0;
        
        pq.add(new Edge(1, 0.0)); // 시작 노드
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;
            
            if (visited[u]) continue;
            visited[u] = true;
            total += current.weight;
            
            // 현재 노드와 연결된 모든 노드 탐색
            for (Node vNode : nodes) {
                if (vNode == null) continue;
                int v = vNode.num;
                if (u == v) continue;
                
                double distance = nodes[u].distanceTo(nodes[v]);
                pq.add(new Edge(v, distance));
            }
            
            // 기존 그래프 간선 추가
            for (Edge e : graph.get(u)) {
                if (!visited[e.to]) {
                    pq.add(e);
                }
            }
        }
        return total;
    }
}
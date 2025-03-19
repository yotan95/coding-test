import java.util.*;
import java.io.*;

public class Main{
    
    static class Star{
        double x,y;
        Star(double x, double y){
            this.x = x;
            this.y = y;
        }

        public double getDistance(Star other){
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y,2));
        }
    }
    static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;
        Edge(int start, int end, double weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return Double.compare(this.weight, e.weight);
        }
    }

    static int n;
    static Star[] stars;
    static List<Edge> edges;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    private static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        stars = new Star[n];
        edges = new ArrayList<Edge>();

        for(int i = 0 ; i < n; i++){
            String[] s = br.readLine().split(" ");
            double x = Double.parseDouble(s[0]);
            double y = Double.parseDouble(s[1]);
            stars[i] = new Star(x,y);
        }
    }
    
    private static void pro(){
        calEdge(stars);
        double result = kruskal(edges, n);
        System.out.println(String.format("%.2f", result));
    }
    private static void calEdge(Star[] s){
        for(int i = 0 ; i < n; i++){
            for(int j = i+1; j < n ;j++){
                double distance = s[i].getDistance(s[j]);
                edges.add(new Edge(i,j, distance));
            }
        }
    }

    private static double kruskal(List<Edge> edges, int vertices){
        makeSet(vertices);
        Collections.sort(edges);
        double total = 0.0;
        int edgeCount = 0;

        for(Edge edge : edges){
            if(edgeCount == vertices-1) break;
            int startRoot = find(edge.start);
            int endRoot = find(edge.end);

            if(startRoot != endRoot){
                total += edge.weight;
                union(startRoot, endRoot);
                edgeCount++;
            }
        }

        return total;
    }


    private static void makeSet(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i = 0 ; i < size; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) return;

        if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        } else if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        } else{
            parent[rootY] = rootX;
            rank[rootX] += 1;
        }
    }
}
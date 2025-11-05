import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int bacon = Integer.MAX_VALUE;
    static int answer;


    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }


    private static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        graph = new ArrayList<ArrayList<Integer>>();

        for(int i = 0 ; i <=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0 ; i < m ; i++){
            s = br.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]);
            int n2 = Integer.parseInt(s[1]);

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
    }

    private static void pro() {
        for(int i = 1 ; i <= n ; i++){
            int baconSum = bfs(i);
            if(baconSum < bacon){
                bacon = baconSum;
                answer = i;
            }
        }
        System.out.println(answer);

    }

    private static int bfs(int start) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<Integer>();

        Arrays.fill(dist, -1);
        dist[start] = 0;
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int adjacent : graph.get(node)){
                if(!visited[adjacent]){
                    visited[adjacent] = true;
                    dist[adjacent] = dist[node] +1;
                    queue.add(adjacent);
                }
            }

        }

        return Arrays.stream(dist).sum();

    }
}
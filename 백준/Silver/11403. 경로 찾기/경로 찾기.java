import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static HashMap<Integer, ArrayList<Integer>> graph;
    static boolean[][] visit;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];
        graph = new HashMap<Integer, ArrayList<Integer>>();
        sb = new StringBuilder();
        
        for(int i = 0 ; i < n ; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < s.length; j++){
                int node = Integer.parseInt(s[j]);
                if(node == 1){
                    graph.putIfAbsent(i, new ArrayList<Integer>());
                    graph.get(i).add(j);
                }
            }
        }
    }
    
    public static void pro(){
         for(int i = 0; i < n; i++){
             for(int j = 0; j < n; j++){
                visit[i][j] = false;
             }
             if(graph.containsKey(i)){
                 ArrayList<Integer> list = graph.get(i);
                 for(int node : list){
                     if(!visit[i][node]){
                         dfs(i, node);
                     }
                }
            }
        }

        
        for(int i = 0; i < visit.length; i++){
            for(int j = 0 ; j < visit[i].length; j++){
                if(visit[i][j]){
                    sb.append(1).append(" ");
                } else{
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    public static void dfs(int start, int node){
        visit[start][node] = true;
    
        if(graph.containsKey(node)){
            ArrayList<Integer> list = graph.get(node);
            for(int next : list){
                if(!visit[start][next]){
                    dfs(start, next);
                }
            }
        }
    }
}
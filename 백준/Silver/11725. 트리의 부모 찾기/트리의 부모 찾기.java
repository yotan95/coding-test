import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    static boolean visit[];
    static int[] parents;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        readData();
        pro(1);
        System.out.print(sb.toString());
    }
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n+1];
        parents = new int[n+1];
        
        for(int i = 1 ; i <= n-1 ; i++){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            
            graph.putIfAbsent(a, new ArrayList<Integer>());
            graph.putIfAbsent(b, new ArrayList<Integer>());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
    
    public static void  pro(int root){
        visit[root] = true;
        ArrayList<Integer> list = graph.get(root);
        if(list != null){
            for(int i = 0 ; i < list.size(); i++){
                int child = list.get(i);
                if(!visit[child]){
                    dfs(root ,child);
                }
            }
        }
        for(int i = 2; i < parents.length; i++){
            sb.append(parents[i]).append("\n");
        }
    }
    
    public static void dfs(int root, int parent){
        visit[parent] = true;
        parents[parent] = root;
        
        ArrayList<Integer> list = graph.get(parent);
        if(list != null){
            for(int i = 0 ; i < list.size(); i++){
                int child = list.get(i);
                if(!visit[child]){
                    dfs(parent, child);
                }
            }
        }
    }
    
}
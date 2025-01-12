import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static boolean[][] visit;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    static StringBuilder sb = new StringBuilder();
        
    public static void main(String[] args) throws IOException{
        readData();
        pro();
        System.out.print(sb.toString());
    }
    
    private static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];
        
        for(int i =0 ; i < n; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < n; j++){
                int node = Integer.parseInt(s[j]);
                if(node == 1){
                    map.putIfAbsent(i, new ArrayList<Integer>());
                    
                    map.get(i).add(j);
                }
            }
        }
    }
    
    private static void pro(){
        for(int key : map.keySet()){
            ArrayList<Integer> list = map.get(key);
            if(list != null){
                for(int i = 0 ; i < list.size(); i++){
                    int node = list.get(i);
                    if(!visit[key][node]){
                        dfs(key, node);
                    }
                }
            }
        }
        
        for(int i = 0 ; i < visit.length; i++){
            for(int j = 0 ; j < visit[i].length; j++){
                if(visit[i][j]){
                    sb.append(1).append(" ");
                }else{
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        
    }
    
    private static void dfs(int key, int node){
        visit[key][node] = true;
        
        ArrayList<Integer> list = map.get(node);
        if(list != null){
            for(int i = 0 ; i < list.size(); i++){
                int el = list.get(i);
                if(!visit[key][el]){
                    dfs(key, el);
                }
            }
        }
    }
}
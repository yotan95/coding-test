import java.util.*;
import java.io.*;

public class Main{
    
    static int n, m, k;
    static int[][] graph;
    static int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        
        visited = new boolean[n+1][m+1];
        graph = new int[n+1][m+1];
        
        for(int i =0 ; i < graph.length; i++){
            Arrays.fill(graph[i], 0);
        }
        
        for(int i = 0; i < k ; i++){
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            graph[x][y] = 1;
        }
    }
    
    public static void pro(){
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++){
            for(int j = 1 ; j <= m ;j++){
                max = Math.max(dfs(i,j), max);
            }
        }
        System.out.print(max);
    }
    
    public static int dfs(int x, int y){
        if(graph[x][y] == 0) return 0;
        int count = 1;
        visited[x][y] = true;
        for(int i = 0 ; i < move.length; i++){
            int nx= x + move[i][0];
            int ny = y + move[i][1];
            if(isAvailable(nx, ny)){
                count += dfs(nx, ny);
            }
        }
        
        return count;
    }
    
    public static boolean isAvailable(int x, int y){
        return x >=1 && x <= n && y >= 1 && y <= m && graph[x][y] != 0 && !visited[x][y];
    }
}
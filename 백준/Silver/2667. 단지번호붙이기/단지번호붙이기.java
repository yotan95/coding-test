import java.util.*;
import java.io.*;

public class Main{
    static int[][] dir ={{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, cnt;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visit;
    static ArrayList<Integer> group;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    private static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visit = new boolean[n][n];

        for(int i = 0 ; i < n;i++){
            String[] s = br.readLine().split("");

            for(int j = 0 ; j < n; j++){
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

    }

    private static void pro(){
        group = new ArrayList<Integer>();
        for(int i =0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(!visit[i][j] && graph[i][j] == 1){
                    cnt = 0;
                    dfs(i,j);
                    group.add(cnt);
                }
            }
        }
        
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for(int c : group){
            sb.append(c).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void dfs(int x, int y){
        cnt++;
        visit[x][y] = true;

        for(int i =0 ; i < dir.length; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny] && graph[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
        
    }
}
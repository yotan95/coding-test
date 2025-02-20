import java.util.*;
import java.io.*;

public class Main{
    private static int n, m;
    private static int[][] graph;
    private static boolean visit[][];
    private static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private static int[][] dist;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    private static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        graph = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];
        dist = new int[n+1][m+1];

        for(int i = 1 ; i < n+1 ; i++){
            s = br.readLine().split("");
            for(int j = 0 ; j < m; j++){
                graph[i][j+1] = Integer.parseInt(s[j]);
            }
        }
    }

    private static void pro(){
        for(int i = 1 ; i < n+1; i++){
            for(int j = 1 ; j < m+1 ; j++){
                dist[i][j] = -1;
            }
        }
        bfs(1,1);
        System.out.print(dist[n][m]);
    }

    private static void bfs(int a, int b){
        visit[a][b] = true;
        dist[a][b] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(a);
        q.add(b);

        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(isValid(nx, ny)){
                    visit[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
    }

    private static boolean isValid(int x , int y){
        return x > 0 && x <=n && y > 0 && y <= m && !visit[x][y] && graph[x][y] == 1;
    }
}
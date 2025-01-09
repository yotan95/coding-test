import java.util.*;
import java.io.*;

public class Main{
    static int m, n, k,t, cnt;
    static int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] check;
    static ArrayList<Integer> group;

    public static void main(String[] args) throws IOException{
        readData();
        System.out.println(sb.toString());
    }
    private static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int j = 0 ; j < t; j ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new int[n][m];
            check = new boolean[n][m];

            for(int i = 0 ; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }
            pro();
            sb.append(cnt).append("\n");
        }
    }

    private static void pro(){
        group  = new ArrayList<Integer>();
        cnt = 0;
        for(int i =0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!check[i][j] && graph[i][j] == 1){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
    }
    private static void dfs(int x, int y){
        check[x][y] = true;

        for(int i = 0; i < move.length; i++){
            int nx = x +move[i][0];
            int ny = y + move[i][1];

            if(nx >= 0 && nx <n && ny >= 0 && ny < m && !check[nx][ny] && graph[nx][ny] == 1){
                dfs(nx,ny);
            }
        }

    }
}
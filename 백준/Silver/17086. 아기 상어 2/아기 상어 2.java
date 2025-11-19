import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[][] graph;
    static int[][] move = {{1,1},{1,0},{-1,-1},{1, -1}, {-1,0}, {-1, 1},{0,1},{0,-1}};
    static int[][] dist;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        dist = new int[n][m];
        queue = new LinkedList<int[]>();
        graph = new int[n][m];

        for(int i = 0 ; i < n; i++){
            Arrays.fill(dist[i], -1);
        }

        for(int i = 0 ; i < n ; i++){
            s = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                graph[i][j] = Integer.parseInt(s[j]);
                if(graph[i][j] == 1){
                    queue.add(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }
    }

    public static void pro(){
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0 ; i < move.length; i++){
                int nx = move[i][0] + x;
                int ny = move[i][1] + y;
                if(nx >=0 && nx < n && ny >=0 && ny < m && dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] +1;
                    queue.add(new int[]{nx, ny});
                }

            }
        }
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < dist.length; i++){
            for(int j = 0 ; j < dist[i].length; j++){
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.print(max);
    }
}
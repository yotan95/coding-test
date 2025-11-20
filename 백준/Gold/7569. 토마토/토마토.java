import java.util.*;
import java.io.*;

public class Main{
    
    static int n, m, h;
    static int[][][] graph;
    static boolean[][][] visited;
    static int[][] move = {{1,0,0}, {0,1,0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static int emptyCount = 0;
    static int existCount = 0;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        h = Integer.parseInt(s[2]);

        graph = new int[h][n][m];
        visited = new boolean[h][n][m];
        queue = new LinkedList<int[]>();

        for(int i = 0 ; i < h; i++){
            for(int j = 0 ; j < n; j++){
                s = br.readLine().split(" ");
                for(int k = 0 ; k < m; k++){
                    graph[i][j][k] = Integer.parseInt(s[k]);
                    if(graph[i][j][k] == 1){
                        queue.add(new int[]{k,j,i});
                        existCount += 1;
                    }
                    if(graph[i][j][k] == -1){
                        emptyCount += 1;
                    }
                }
            }
        }
    }

    public static void pro(){
        int day = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int z = node[2];
            visited[z][y][x] = true;
            for(int i = 0 ;i < move.length; i++){
                int nx = move[i][0] + x;
                int ny = move[i][1] + y;
                int nz = move[i][2] + z;
                if(isAvailable(nx, ny, nz)){
                    visited[nz][ny][nx] = true;
                    graph[nz][ny][nx] = graph[z][y][x]+1;
                    queue.add(new int[]{nx,ny,nz});
                }
            }
        }


        for(int i = 0; i < h ; i++){
            for(int j = 0 ; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(graph[i][j][k] == 0){
                        System.out.print(-1);
                        return;
                    }
                    day = Math.max(day, graph[i][j][k]);
                }
            }
        }
        System.out.print(day-1);
    }

    public static boolean isAvailable(int x, int y, int z){
        return x >= 0 && x < m && y >= 0 && y < n && z >= 0 && z < h && graph[z][y][x] == 0 && !visited[z][y][x];
    }
}
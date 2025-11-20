import java.util.*;
import java.io.*;

public class Main{
    static int loop;
    static int[] start;
    static int[] goal;
    static int[][] graph;
    static int[][] move = {{-2,1},{-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
    static Queue<int[]> queue;
    static boolean[][] visited;
    static int size;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        loop = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < loop; i++){
            size = Integer.parseInt(br.readLine());
            queue = new LinkedList<int[]>();
            graph = new int[size][size];
            visited = new boolean[size][size];
            for(int k = 0 ; k < graph.length; k++){
                Arrays.fill(graph[k], Integer.MAX_VALUE);
            }
            String[] s = br.readLine().split(" ");

            int x = Integer.parseInt(s[0]);
            int y =Integer.parseInt(s[1]);
            start  = new int[]{x,y};
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y =Integer.parseInt(s[1]);
            goal = new int[]{x,y};

            queue.add(start);
            bfs();
        }

        System.out.print(sb.toString());
    }

    public static void bfs(){
        graph[start[0]][start[1]] = 0;
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            for(int i = 0 ; i < move.length; i++){
                int nx = move[i][0] + x;
                int ny = move[i][1] + y;
                if(isValid(nx, ny)){
                    visited[nx][ny] = true;
                    graph[nx][ny] = Math.min(graph[x][y] + 1, graph[nx][ny]);
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        sb.append(graph[goal[0]][goal[1]]).append("\n");
    }

    public static boolean isValid(int x, int y){
        return x >= 0 && x < size && y >= 0 && y < size && !visited[x][y];
    }
    
}
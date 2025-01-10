import java.util.*;
import java.io.*;

public class Main{
    static int w, h, cnt;
    static boolean[][] visit;
    static int[][] graph;
    static int[][] dir = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        readData();
        System.out.print(sb.toString());
    }

    public static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            visit = new boolean[h][w];
            graph = new int[h][w];
            cnt = 0;
            
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            pro();
        }
    }

    public static void pro() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append("\n");
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visit[nx][ny] && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
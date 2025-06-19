import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[][] graph;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        readData();
        pro();
    }

    public static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
       
        dp = new int[n][n][3];
    }

    public static void pro() {
        dp[0][1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (graph[i][j] == 1) continue;

                if (j - 1 >= 0) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                }

                if (i - 1 >= 0) {
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (graph[i - 1][j] == 0 && graph[i][j - 1] == 0 && graph[i][j] == 0) {
                        dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }
        int result = dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2];
        System.out.println(result);
    }
}
import java.util.*;
import java.io.*;

public class Main{
    
    static int n, max = Integer.MIN_VALUE;
    static int[][] graph, dp;
    
    public static void main(String[] args) throws IOException{
        readData();
        
        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(pro(0, 0));
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        
        graph = new int[n][n];
        dp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < i+1 ; j++){
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
    }
    
    public static int pro(int x, int y){
        if(x == n-1) {
            return graph[x][y];
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        
        dp[x][y] = graph[x][y] + Math.max(pro(x+1, y), pro(x+1, y+1));
        return dp[x][y];
    }
    
    public static boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
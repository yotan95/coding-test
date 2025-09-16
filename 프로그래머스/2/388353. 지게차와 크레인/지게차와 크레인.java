import java.util.*;
import java.io.*;

class Solution {
    static int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static boolean[][] visit;
    static int n, m, count, answer;
    static char[][] graph;


    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        graph = new char[n][m];
        answer = n*m;
        count = 0;

        for(int i = 0 ; i < n; i++){
            graph[i] = storage[i].toCharArray();
        }

        for(String request : requests){

            if(request.length() == 1){
                lift(request.charAt(0));
            }
            if(request.length() == 2){
                crane(request.charAt(0));
            }
        }


        return answer;
    }

    static void crane(char target){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == target) {
                    answer--;
                    graph[i][j] = 0;
                }
            }
        }
    }

    static void lift(char target){
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            if(!visit[i][0]) dfs(i, 0, target);
            if(!visit[i][m-1]) dfs(i, m-1, target);
        }
        for(int i = 0; i < m; i++) {
            if(!visit[0][i]) dfs(0, i, target);
            if(!visit[n-1][i]) dfs(n-1, i, target);
        }
    }

    static void dfs(int x, int y, char target){
        visit[x][y] = true;
        if(graph[x][y] == 0) {
            for(int i = 0; i < move.length; i++) {
                int lx = x + move[i][0];
                int ly = y + move[i][1];
                if(lx < 0 || ly < 0 || lx >= n || ly >= m) continue;
                if(!visit[lx][ly]) dfs(lx, ly, target);
            }
        }
        if(graph[x][y] == target) {
            answer--;
            graph[x][y] = 0;
        }

    }
}

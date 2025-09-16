import java.util.*;
import java.io.*;

class Solution {
    static int n, m, count;
    static char[][] graph;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        graph = new char[n][m];
        count = 0;
        for (int i = 0; i < n; i++) graph[i] = storage[i].toCharArray();
        
        for (String req : requests) {
            if (req.length() == 1) {
                lift(req.charAt(0));
            } else {
                crane(req.charAt(0));
            }
        }
        return count; // 문제에 따라 반환값이 총 제거 개수인지 남은 칸인지 다름. 원래 사용하던 방식에 맞춰 바꾸세요.
        // (원래 코드는 answer = n*m; answer -= count; return answer; 였음)
    }
    
    // 크레인: 해당 문자 전부 제거
    static void crane(char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == target) {
                    graph[i][j] = ' ';
                    count++;
                }
            }
        }
    }
    
    // 리프트: 네 방향(위, 아래, 왼쪽, 오른쪽)에서 각각 "처음 만나는" 칸을 확인하여 target이면 제거
    static void lift(char target) {
        // 위 -> 아래 (각 열)
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (graph[i][j] != ' ') {
                    if (graph[i][j] == target) {
                        graph[i][j] = ' ';
                        count++;
                    }
                    break;
                }
            }
        }
        // 아래 -> 위 (각 열)
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (graph[i][j] != ' ') {
                    if (graph[i][j] == target) {
                        graph[i][j] = ' ';
                        count++;
                    }
                    break;
                }
            }
        }
        // 왼쪽 -> 오른쪽 (각 행)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != ' ') {
                    if (graph[i][j] == target) {
                        graph[i][j] = ' ';
                        count++;
                    }
                    break;
                }
            }
        }
        // 오른쪽 -> 왼쪽 (각 행)
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (graph[i][j] != ' ') {
                    if (graph[i][j] == target) {
                        graph[i][j] = ' ';
                        count++;
                    }
                    break;
                }
            }
        }
    }
}

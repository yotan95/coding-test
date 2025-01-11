import java.util.*;
import java.io.*;

public class Main{
    static int com, pair, count;
    static boolean[] visit;
    static HashMap<Integer, ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        readData();
        pro();
    }

    public static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        com = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());
        visit = new boolean[com + 1];
        graph = new HashMap<>();

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(n1, new ArrayList<>());
            graph.putIfAbsent(n2, new ArrayList<>());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1); // 양방향 간선 추가
        }
    }

    public static void pro() {
        dfs(1); // 노드 "1"에서만 탐색 시작 (문제 조건에 따라)
        System.out.print(count - 1); // 자기 자신(노드 "1") 제외한 카운트 출력
    }

    public static void dfs(int x) {
        if (visit[x]) return; // 이미 방문한 경우 종료

        visit[x] = true; // 방문 표시
        count++; // 방문한 노드 카운트 증가

        ArrayList<Integer> list = graph.get(x);
        if (list != null) {
            for (int element : list) {
                if (!visit[element]) { // 방문하지 않은 경우만 DFS 호출
                    dfs(element);
                }
            }
        }
    }

}
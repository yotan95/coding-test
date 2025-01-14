import java.util.*;
import java.io.*;

class State {
    int[] x;

    State(int[] arr) {
        x = new int[3];
        for (int i = 0; i < 3; i++) x[i] = arr[i];
    }

    State move(int from, int to, int[] Limit) {
        int[] nx = new int[]{x[0], x[1], x[2]};
        if (x[to] + x[from] >= Limit[to]) {
            nx[from] -= Limit[to] - x[to];
            nx[to] = Limit[to];
        } else {
            nx[to] += x[from];
            nx[from] = 0;
        }
        return new State(nx);
    }
}

public class Main {

    static int a, b, c;
    static boolean[][][] visit;
    static boolean[] possible;
    static int[] limit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        readData();
        pro();
    }

    private static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);
        limit = new int[]{a, b, c};
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }

    private static void pro() {
        bfs(0, 0, limit[2]);
        for (int i = 0; i <= limit[2]; i++) {
            if (possible[i]) sb.append(i).append(" ");
        }
        System.out.print(sb.toString().trim());
    }

    private static void bfs(int x1, int x2, int x3) {
        Queue<State> queue = new LinkedList<>();
        visit[x1][x2][x3] = true;
        queue.add(new State(new int[]{x1, x2, x3}));

        while (!queue.isEmpty()) {
            State node = queue.poll();
            if (node.x[0] == 0) possible[node.x[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    State next = node.move(from, to, limit);

                    if (isValid(next)) {
                        if (!visit[next.x[0]][next.x[1]][next.x[2]]) {
                            visit[next.x[0]][next.x[1]][next.x[2]] = true;
                            queue.add(next);
                        }
                    }
                }
            }
        }
    }

    private static boolean isValid(State state) {
        return state.x[0] >= 0 && state.x[0] <= limit[0]
                && state.x[1] >= 0 && state.x[1] <= limit[1]
                && state.x[2] >= 0 && state.x[2] <= limit[2];
    }
}

import java.util.*;
import java.io.*;

public class Main{
    static int n, m, start;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] dfsCheck, bfsCheck;


    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        dfsCheck = new boolean[n+1];
        bfsCheck = new boolean[n+1];

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(a,new ArrayList<Integer>());
            graph.putIfAbsent(b, new ArrayList<Integer>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    public static void pro(){
        dfs(start);
        sb.append("\n");
        bfs(start);
        System.out.print(sb.toString());
    }

    public static void dfs(int x){
        dfsCheck[x] = true;
        sb.append(x).append(" ");
        ArrayList<Integer> list = graph.get(x);
        if(list != null) {
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i);
                if (!dfsCheck[a]) {
                    dfs(a);
                }
            }
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        sb.append(x).append(" ");
        bfsCheck[x] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            ArrayList<Integer> list = graph.get(node);
            if(list != null) {
                Collections.sort(list);
                for (int i = 0; i < list.size(); i++) {
                    if (!bfsCheck[list.get(i)]) {
                        bfsCheck[list.get(i)] = true;
                        sb.append(list.get(i)).append(" ");
                        q.add(list.get(i));
                    }
                }
            }
        }

    }
}
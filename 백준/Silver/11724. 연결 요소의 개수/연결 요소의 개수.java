import java.util.*;
import java.io.*;

public class Main{
    static int n, m, cnt;
    static boolean[] visit;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(x, new ArrayList<Integer>());
            graph.putIfAbsent(y, new ArrayList<Integer>());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
    }

    public static void pro(){
        cnt = 0;
        for(int i = 1;  i <= n; i++){
            if(!visit[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    public static void dfs(int num){
        visit[num] = true;
        ArrayList<Integer> list = graph.get(num);
        if(list != null){
            for(int i =0 ; i < list.size(); i++){
                if(!visit[list.get(i)]){
                    dfs(list.get(i));
                }
            }
        }
    }
}
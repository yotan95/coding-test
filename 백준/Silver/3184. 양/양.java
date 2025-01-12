import java.util.*;
import java.io.*;

public class Main{
    static int w, h, o, v;
    static boolean visit[][];
    static String[][] graph;
    static int[][] dir = {{1,0}, {-1, 0}, {0,1}, {0, -1}};
    static ArrayList<Integer> Ol, Vl;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }


    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        h = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);

        visit = new boolean[h][w];
        graph = new String[h][w];
        Ol = new ArrayList<Integer>();
        Vl = new ArrayList<Integer>();

        for(int i = 0; i < h; i++){
            s = br.readLine().split("");
            for(int j = 0 ; j < s.length; j++){
                graph[i][j] = s[j];
            }
        }
    }

    public static void pro(){
        for(int i = 0 ; i < h; i++){
            for(int j = 0 ; j < w; j++){
                if(!visit[i][j] && isAvailable(i,j)){
                    o = 0;
                    v = 0;
                    dfs(i, j);
                    if(o > v){
                        Ol.add(o);
                    } else {
                        Vl.add(v);
                    }
                }
            }
        }
        int Osum = 0, Vsum = 0;
        for(int o : Ol){
            Osum += o;
        }
        for(int v : Vl){
            Vsum += v;
        }
        System.out.print(Osum+" "+Vsum);
    }

    public static void dfs(int x, int y){
        visit[x][y] = true;
        if(graph[x][y].equals("o")) o++;
        else if( graph[x][y].equals("v")) v++;

        for(int i = 0 ; i < dir.length; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx >=0 && nx < h && ny >= 0 && ny < w && !visit[nx][ny] && isAvailable(nx, ny)){
                dfs(nx, ny);
            }
        }
    }

    public static boolean isAvailable(int i, int j){
        if(graph[i][j].equals(".") || graph[i][j].equals("o") || graph[i][j].equals("v")){
            return true;
        }
        return false;
    }
}
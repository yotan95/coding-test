import java.util.*;
import java.io.*;

public class Main{
    
    public static int n;
    public static int[][] info;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        info = new int[n][2];

        for(int i = 0 ; i < n ;i++){
            String[] s = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(s[0]);
            info[i][1] = Integer.parseInt(s[1]);
        }
    }

    public static void pro(){
        Arrays.sort(info,(a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int max = 0;
        int cnt = 0;

        for(int i = 0 ; i < n; i++){
            if(max <= info[i][0]){
                max = info[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
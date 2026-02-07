import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static int[] parents;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        parents = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            parents[i] = i;
        }
        for(int i = 0 ; i < n-2; i++){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            union(a,b);
        }

        
    }

    public static void pro(){
        int root1 = find(1);
        
        for(int i =2 ; i <= n; i++){
            int rootI = find(i);
            
            if(root1 != rootI){
                System.out.print("1 " + rootI);
                return;
            }
        }
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) parents[rootB] = rootA;
    }
    public static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    

    
}
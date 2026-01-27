import java.util.*;
import java.io.*;

public class Main{
   
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0 ; j < 3; j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
    }
    
    public static void pro(){
        for(int i = 1; i < n; i++){
            arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
        }
        System.out.println(Math.min(arr[n-1][0], Math.min(arr[n-1][1], arr[n-1][2])));
    }
}
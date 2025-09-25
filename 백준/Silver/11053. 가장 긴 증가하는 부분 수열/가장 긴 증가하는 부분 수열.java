import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static int[] list;
    static int[] dp;
    
    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        dp = new int[n];
        
        String[] s = br.readLine().split(" ");
        for(int i = 0 ; i < s.length; i++){
            list[i] = Integer.parseInt(s[i]);
            dp[i] = 1;
        }
        
    }
    public static void pro(){
        for(int i = 1 ; i < n; i++){
            for(int j = 0 ; j < i; j++){
                if(list[i] > list[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        
        int temp = 0;
        for(int i = 0 ; i < dp.length; i++){
            temp = Math.max(temp, dp[i]);
        }
        
        System.out.print(temp);
    }
}
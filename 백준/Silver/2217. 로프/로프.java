import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static int[] rope;
    
    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rope = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
    }
    
    public static void pro(){
        Arrays.sort(rope);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i< rope.length; i++){
            int temp = rope[i] * (rope.length - i);
            max = Math.max(max, temp);
        }
        
        System.out.print(max);
        
    }
}
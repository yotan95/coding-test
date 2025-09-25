import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static int[] A;
    static Integer[] B;
    
    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        A = new int[n];
        B = new Integer[n];

        String[] s = br.readLine().split(" ");
        for(int j = 0 ; j < n; j++){
            A[j] = Integer.parseInt(s[j]);
        }

        s = br.readLine().split(" ");
        for(int j = 0 ; j < n; j++){
            B[j] = Integer.parseInt(s[j]);
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
    }
    
    public static void pro(){
        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            answer += A[i] * B[i];
        }
        
        System.out.print(answer);
    }
}
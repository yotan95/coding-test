import java.util.*;
import java.io.*;

public class Main{
    
    static int[][] dp;
    static int n, k;
    static int[] w, v;
    
    public static void main(String[] args) throws IOException{
        readData();
        pro();
        System.out.println(dp[n][k]);  // 결과 출력
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        
        w = new int[n + 1];  // 1번 인덱스부터 사용
        v = new int[n + 1];  // 1번 인덱스부터 사용
        
        dp = new int[n + 1][k + 1];  // 0~n, 0~k 인덱스
        
        for(int i = 1; i <= n; i++){  // 1번 인덱스부터 저장
            s = br.readLine().split(" ");
            w[i] = Integer.parseInt(s[0]);
            v[i] = Integer.parseInt(s[1]);
        }
    }
    
    public static void pro(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(w[i] > j) {  // 현재 물건이 무게 제한 초과
                    dp[i][j] = dp[i - 1][j];  // 이전 물건까지의 최댓값
                }
                else {  // 현재 물건을 넣을 수 있는 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
    }
}
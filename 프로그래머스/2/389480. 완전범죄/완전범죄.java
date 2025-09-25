import java.util.*;

class Solution {
    
    public int solution(int[][] info, int n, int m) {
        
        int[][] dp = new int[info.length + 1][m];
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0 ; i <= info.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][0] = 0;
        
        for(int i = 1 ; i <= info.length; i++){
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            for(int j = 0  ; j < m; j++){
                if(dp[i-1][j] == Integer.MAX_VALUE) continue;
                
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                
                if(b +j < m){
                    dp[i][j+b] = Math.min(dp[i][j + b], dp[i-1][j]);
                }
            }
        }
        
        
        for(int i = 0 ; i < m; i++){
            if(dp[info.length][i] < n){
                answer = Math.min(answer, dp[info.length][i]);
            }
        }
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        
        return answer;
    }

}
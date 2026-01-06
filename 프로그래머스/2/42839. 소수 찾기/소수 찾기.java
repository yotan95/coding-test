import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<Integer>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "", 0);
        
        for(int num : set){
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(String numbers,String current, int depth){
        
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
        }
        if(depth == numbers.length()){
            return;
        }
        
        for(int i = 0 ; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, current+numbers.charAt(i), depth+1);
                visited[i]=false;
            }
            
        }
    }

    public static boolean isPrime(int n){
        if(n <2) return false;
        
        for(int i =2 ; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}
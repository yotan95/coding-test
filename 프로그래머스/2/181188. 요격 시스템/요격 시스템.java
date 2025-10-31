import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        int last = targets[0][1];
        answer++;
        for(int i = 1 ; i < targets.length; i++){
            int[] current = targets[i];
            
            if(current[0] < last) {
                continue;
            }
            answer++;
            last = current[1];
            
        }
        return answer;
    }
}
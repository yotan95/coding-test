import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long start = times[0];
        long end = times[times.length - 1] * (long)n;
        long mid;
        
        while(start <= end){
            mid = (start + end) / 2;
            long sum = 0;
            
            for(int time : times){
                sum += mid / time;
                
            }
            if(sum >= n){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }
        
        
        return answer;
    }
}
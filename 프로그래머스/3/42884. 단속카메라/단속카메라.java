import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[][] routes) {
    
        
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        int camera = 1;
        int lastPoint = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            int route = routes[i][0];
            
            if(lastPoint < route){
                camera++;
                lastPoint = routes[i][1];
            }
        }
        
        return camera;
        
    }
}
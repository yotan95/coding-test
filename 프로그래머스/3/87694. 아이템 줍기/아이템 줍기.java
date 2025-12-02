import java.util.*;

class Solution {

    static int[][] grid;
    static boolean[][] visited;
    static int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        grid = new int[102][102];
        visited = new boolean[102][102];
        
        
        for(int i = 0; i < rectangle.length; i++){
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int x = x1; x <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    grid[x][y] = 1;
                }
            }
        }
        
    
        for(int i = 0; i < rectangle.length; i++){
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int x = x1 + 1; x < x2; x++){ 
                for(int y = y1 + 1; y < y2; y++){
                    grid[x][y] = 0;
                }
            }
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    public static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if(x == endX && y == endY){
                return dist / 2;
            }
            
            for(int[] m : move){
                int nx = x + m[0];
                int ny = y + m[1];
                
                if(nx >= 0 && ny >= 0 && nx < 102 && ny < 102 &&
                   grid[nx][ny] == 1 && !visited[nx][ny]){ 
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }
}

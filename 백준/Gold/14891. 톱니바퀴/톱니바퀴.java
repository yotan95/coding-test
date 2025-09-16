import java.util.*;
import java.io.*;

public class Main{
    static int[][] wheel;
    static int[][] rotation;
    static int k, total;
    static final int last = 8, first = 1;
    static int[] reward = new int[]{0,1,2,4,8};
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
        System.out.print(total);
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = 0;
        wheel = new int[5][9];

        for(int i = 1 ; i <= 4; i++){
            String s = br.readLine();
            for(int j = 1; j < 9; j++){
                int num = Integer.parseInt(s.substring(j-1,j));
                wheel[i][j] = num;
            }
        }

        k = Integer.parseInt(br.readLine());
        rotation = new int[k][2];

        for(int i = 0 ; i < k ; i++){
            String[] s =  br.readLine().split(" ");
            rotation[i][0] = Integer.parseInt(s[0]);
            rotation[i][1] = Integer.parseInt(s[1]);
        }
    }

    public static void pro(){
        for(int i = 0 ; i < k ; i++) {
            int target = rotation[i][0];
            int course = rotation[i][1];

            int[] dir = new int[5];
            dir[target] = course;

            // target 부터 오른쪽
            for(int j = target; j < 4; j++){
                if(wheel[j][3] != wheel[j+1][7]){
                    dir[j+1] = -dir[j];
                } else{
                    break;
                }
            }

            for(int j = target; j > 1; j--) {
                if(wheel[j][7] != wheel[j-1][3]){
                    dir[j-1] = -dir[j];
                } else{
                    break;
                }
            }

            for(int j = 1; j <= 4; j++){
                if(dir[j] != 0){
                    spin(j,dir[j]);
                }
            }

        }

        for(int i = 1; i <= 4; i++){
            if(wheel[i][1] == 1) total += reward[i];
        }
    }

    public static void spin(int target, int rotationDir){
        if(rotationDir == 1){
            int temp = wheel[target][last];
            for(int i = last ; i > first; i--){
                wheel[target][i] = wheel[target][i-1];
            }
            wheel[target][first] = temp;
        } else {
            int temp = wheel[target][first];
            for(int i = first; i < last; i++){
                wheel[target][i] = wheel[target][i+1];
            }
            wheel[target][last] = temp;
        }
    }
}
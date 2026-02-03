import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main{
    
    static int n;
    static String[] waves;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        waves = new String[n];
        sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            waves[i] = br.readLine();
        }
    }
    
    public static void pro(){
        Pattern pattern = Pattern.compile("(100+1+|01)+");
        
        for(String s : waves){
            if(pattern.matcher(s).matches()){
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}

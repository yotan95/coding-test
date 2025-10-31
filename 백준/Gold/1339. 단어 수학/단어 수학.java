import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static ArrayList<String> graph;
    static HashMap<Character,Integer> map;

    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<String>();
        map = new HashMap<Character, Integer>();

        for(int i = 0 ; i < n; i++){
            String temp = br.readLine().trim();
            graph.add(temp);

            for(int j = 0 ; j < temp.length(); j++){
                char c = temp.charAt(j);
                int pow = (int)Math.pow(10, temp.length() - 1 - j);
                map.put(c, map.getOrDefault(c,0) + pow);
            }
        }
    }

    public static void pro(){
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a,b)-> map.get(b) - map.get(a));
        int total = 0;
        int score = 9;

        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();

        for(char ch : list){
            dict.put(ch, score);
            score--;
        }

        for(String word : graph){
            int value = 0;
            for(char ch : word.toCharArray()){
                value = value * 10 + dict.get(ch);
            }
            
            total += value;
        }

        System.out.println(total);
    }
}
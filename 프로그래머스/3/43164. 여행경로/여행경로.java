import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<String>();
    static boolean[] check;
    
    public String[] solution(String[][] tickets) {
        String start = "ICN";
        check = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2) -> {
                   if(o1[0].equals(o2[0])){
                       return o1[1].compareTo(o2[1]);
                   }
                    return o1[0].compareTo(o2[0]);
        });
        
        search(tickets, start, start, 0);
        
        Collections.sort(list);
        
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    
    public static void search(String[][] tickets, String start, String target, int count){
        if(tickets.length == count){
            list.add(target);
            return;
        }
        
        for(int i = 0 ; i < tickets.length; i++){
            if(start.equals(tickets[i][0]) && !check[i]){
                check[i] = true;
                search(tickets, tickets[i][1], target + " " + tickets[i][1], count+1);
                check[i] = false;
            }
        }
        
    }
}
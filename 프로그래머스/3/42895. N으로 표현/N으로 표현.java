import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] set = new HashSet[9];
        for(int i = 0; i < set.length; i++){
            set[i] = new HashSet();
        }
        
        for(int i = 1 ; i <= 8; i++){
            String s= "";
            for(int j = 0; j <i; j++){
                s += N;
            }
            set[i].add(Integer.parseInt(s));
        }
        
        for(int i =1 ; i <= 8; i++){
            for(int j = 1; j < i; j++){
                for(int a : set[j]){
                    for(int b : set[i-j]){
                        set[i].add(a-b);
                        set[i].add(a+b);
                        set[i].add(a*b);
                        if(b != 0 ) set[i].add(a/b);
                    }
                }
            }
        }
        
        for(int i = 0 ; i < set.length; i++){
            if(set[i].contains(number)){
                return i;
            }
        }
        
        
        
        return -1;
    }
}
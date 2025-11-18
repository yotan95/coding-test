class Solution {
    
    static boolean found = false;
    static int answer = 0;
    static String[] dict = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfFunc(new StringBuilder(), word);
        return answer;
    }
    
    public static void dfFunc(StringBuilder canString, String target){
        if(found) return;
        
        if(canString.length() > 0){
            answer++;
            if(target.equals(canString.toString())){
                found = true;
                return;
            }
        }
        
        if(canString.length() == 5){
            return;
        }
        
        for(int pivot = 0 ; pivot < 5; pivot++){
            canString.append(dict[pivot]);
            dfFunc(canString, target);
            canString.deleteCharAt(canString.length()-1);
            if(found) return;
        }
    }
    
    
}
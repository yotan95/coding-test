class Solution {
    static int count = 0;
    static String[] operator = {"+", "-"};
    public int solution(int[] numbers, int target) {
        
        dpFunc(numbers, target, numbers.length, 0, 0);
        
        return count;
    }
    
    public static void dpFunc(int[] numbers, int target, int n, int result, int startIndex){
        if(startIndex == n){
            if(result == target){
                count++;
                return;
            }
            return;
        }
        dpFunc(numbers, target, n, result+numbers[startIndex], startIndex+1);
        dpFunc(numbers, target, n, result-numbers[startIndex], startIndex+1);
    }
}
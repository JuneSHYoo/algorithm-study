import java.util.*;

class Solution {
    
    static Set<Integer> set;
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;
        
        set = new HashSet<>();
        // 가능한 순열 찾기
        dfsPer(numbers, "",0);
        
        System.out.println(set);
        
        for(Integer s :set){
            if(isPrime(s)) answer++;
        }
        
        
        return answer;
    }
    
    private static boolean isPrime(int n){
        if(n<2) return false;
        
        for(int i=2; i<= (int) Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        
        return true;
    }
    
    private static void dfsPer(String numbers, String s, int depth){
        
        if(depth>numbers.length()){
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                set.add( Integer.parseInt(s+numbers.charAt(i)  ));
                dfsPer(numbers, s+numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
        
    }
}
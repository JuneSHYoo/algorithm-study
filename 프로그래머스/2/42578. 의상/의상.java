import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> m = new HashMap<>();
        
        for(String[] c : clothes){
            if(!m.containsKey(c[1])){
                m.put(c[1],1);
            }else{
                m.put(c[1], m.get(c[1])+1);
            }
        }
        
        for(int i : m.values()){
            answer*=(i+1);
        }
        return answer-1;
    }
}
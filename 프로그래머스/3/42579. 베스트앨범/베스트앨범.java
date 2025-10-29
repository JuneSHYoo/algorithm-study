import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> g = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> p = new HashMap<>();
        
        for(int i=0; i<genres.length ; i++){
            if(!g.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                
                p.put(genres[i], map);
                g.put(genres[i], plays[i]);
                
            }else{
                p.get(genres[i]).put(i, plays[i]);
                g.put(genres[i], g.get(genres[i])+plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList(g.keySet());
        Collections.sort(keySet, (s1, s2) -> g.get(s2) - g.get(s1));

        for(String k: keySet){
            HashMap<Integer, Integer> m = p.get(k);
            List<Integer> mKeySet = new ArrayList(m.keySet());
            
            Collections.sort(mKeySet, (s1, s2) -> m.get(s2) - m.get(s1));
            
            answer.add(mKeySet.get(0));
            if(mKeySet.size() >1){
                answer.add(mKeySet.get(1));
            }
            
        }    
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}

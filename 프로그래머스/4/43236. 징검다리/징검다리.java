import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        ArrayList<Integer> rock = new ArrayList<>();
        rock.add(0);
        rock.add(distance);
        for(int r : rocks){
            rock.add(r);
        }
        Collections.sort(rock);   
        
        int left = 1;
        int right = distance;
        
        
        while(left<=right){
            
            int mid = (left+right) / 2;
            int rmvCnt = 0;
            int cur = rock.get(0);
            
            for(int i=1 ; i<rock.size() ; i++){
                int diff = rock.get(i) - cur;
                if(diff < mid ){
                    rmvCnt++;
                }else {
                    cur = rock.get(i);
                }
            } 
            
            if(rmvCnt <= n) {
                answer = mid;
                left = mid + 1;
            }else {
                right = mid-1 ;
            } 
        }
        
        
        int maxGap = maxGapGivenMin(rock, answer);
        
        return answer;
    }
    
    private int maxGapGivenMin(List<Integer> rock, int minGap) {
        int last = rock.get(0);
        int maxGap = 0;
        for (int i = 1; i < rock.size(); i++) { // 끝(distance)까지 포함
            int diff = rock.get(i) - last;
            if (diff < minGap) {
                // 제거 (last 유지해서 간격 누적)
            } else {
                // 유지 → 구간 하나 확정
                if (diff > maxGap) maxGap = diff;
                last = rock.get(i);
            }
        }
        return maxGap;
    }
    
    
}
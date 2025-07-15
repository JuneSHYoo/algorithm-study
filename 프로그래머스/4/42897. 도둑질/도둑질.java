import java.util.*;

class Solution {
    static int[] d1 = new int[1000001];
    static int[] d2 = new int[1000001];
    public int solution(int[] money) {
        
        int n = money.length;
        int answer = 0;
        
        // 첫번째 집 방문 (마지막 집 안돌아)
        d1[1] = money[0];
        d1[2] = Math.max(d1[0],d1[1]);
        
         for(int i=3; i<n ; i++){
            d1[i] = Math.max(d1[i-2],d1[i-3]) + money[i-1];
        }
        
        // 첫번째 집 미방문 (막집 갈 수 있어)
        d2[2] = money[1];
        d2[3] = Math.max(d2[1],money[2]);
        
        for(int i=4 ; i <= n; i++){
            d2[i] =  Math.max(d2[i-2],d2[i-3]) + money[i-1];
        }
        
        int m1 = 0 ;
        for(int m : d1){
            if(m1 < m){
                m1 = m;
            }
        }
        
        
        int m2 = 0 ;
        for(int m : d2){
            if(m2 < m){
                m2 = m;
            }
        }
        
        answer = Math.max(m1,m2);
        return answer;
    }
}
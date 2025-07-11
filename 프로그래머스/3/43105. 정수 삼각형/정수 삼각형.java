import java.util.*;

class Solution {
    
    static int[][] d;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        d = new int[n][];
        
        d[0] = new int[1];
        d[0][0] = triangle[0][0];
        
       
        for(int i=1;i<n;i++){
            int m = triangle[i].length;
            d[i] = new int[m];
            
            for(int j=0; j<m ; j++){
                if(j==0) {
                    d[i][j] = triangle[i][j] + d[i-1][j];
                } else if(j == m-1){
                    d[i][j] = triangle[i][j] + d[i-1][j-1];
                } else {
                    d[i][j] = triangle[i][j] + Math.max(d[i-1][j] , d[i-1][j-1]);
                }
            }
        }
        
        Arrays.sort(d[n-1]);
        answer = d[n-1][n-1];
        return answer;
    }
}
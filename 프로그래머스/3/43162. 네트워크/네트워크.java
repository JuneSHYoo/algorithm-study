import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0; i<n ; i++){
            if(!visited[i]){
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int root, int n  , int[][] computers){
        Stack<Integer> s = new Stack<>();
        
        s.push(root);
        visited[root] = true;
        
        while(!s.isEmpty()){
            int cur = s.pop();
            
            for(int i = 0; i<n ; i++){
                if(computers[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    s.push(i);
                }
            }
            
        }  
    }

}
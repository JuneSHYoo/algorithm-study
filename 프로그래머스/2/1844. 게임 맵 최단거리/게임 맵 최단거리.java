import java.io.*;
import java.util.*;

class Solution {
    
    static int n,m;
    static int[][] dist;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int mCount = 26;
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        dist = new int[n][m];
        
        // 최단 거리 bfs
        Queue<int[]> q = new LinkedList<>(); 
        dist[0][0] = 1;
        
        q.offer(new int[]{0,0}); // 시작점
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            
            for(int d=0 ; d<4 ; d++){
                int nx = cx + dx[d] , ny = cy + dy[d];
                
                if( nx >= 0 && nx < n && ny >= 0 && ny < m &&
                   maps[nx][ny] == 1 && dist[nx][ny] == 0){
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
        
    }
    
    
    
}
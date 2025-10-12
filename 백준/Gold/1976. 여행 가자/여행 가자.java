import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static ArrayList<Integer>[] map;
    static int[] plan;
    static boolean ans = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N+1];
        plan = new int[M];

        for(int i=1; i<=N; i++){
            map[i] = new ArrayList();
            int[] city = sToIArr(br.readLine());
            for(int j=0; j<N;j++){
                if(city[j] == 1){
                    map[i].add(j+1);
                }
            }
        }
        plan = sToIArr(br.readLine());

        if(M==1){
            bw.write("YES");
            bw.flush();
            bw.close();
            return;
        }
        for(int i=0;i<plan.length-1; i++){
            boolean yn = bfs(plan[i], plan[i+1]);

            if(yn == true){
                ans = true;
            }else{
                ans = false;
                break;
            }
        }
        String result = ans ? "YES" : "NO"; 

        bw.write(result);
        bw.flush();
        bw.close();


    }

    private static boolean bfs(int s, int e){
        if(s == e ) return true;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int n : map[cur]){
                if (!visited[n]) {
                    if (n == e) return true;   // 목적지 발견
                    visited[n] = true;         
                    q.offer(n);
                }
            }
        }
        return false;
    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}

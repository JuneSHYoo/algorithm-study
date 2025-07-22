import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        int[][] study = new int[n][2];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            study[i][0] = Integer.parseInt(st.nextToken());
            study[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(study, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0]-b[0];
            }
        });

        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(study[0][1]);

        for(int i=1 ; i < n; i++){
            if(pq.peek() <= study[i][0]){
                pq.poll();
            }

            pq.offer(study[i][1]);
        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();

    }
    
}

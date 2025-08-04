import java.io.*;
import java.util.*;

public class Main{

    static int T,A,B;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine().trim());

        while(T-->0){
            visited = new boolean[10000];
            int[] input = sToIArr(br.readLine());
            A = input[0];
            B = input[1];

            Queue<Register> q = new LinkedList<>();
            q.add(new Register(A,""));
            visited[A] = true;

            while(!q.isEmpty()){
                Register cur = q.poll();

                if(cur.n == B){
                    bw.write(cur.cal+"\n");
                    break;
                }

                if(!visited[cur.D()]){
                    q.add(new Register(cur.D(),cur.cal+"D"));
                    visited[cur.D()] = true;
                }
                if(!visited[cur.S()]){
                    q.add(new Register(cur.S(),cur.cal+"S"));
                    visited[cur.S()] = true;
                }
                if(!visited[cur.L()]){
                    q.add(new Register(cur.L(), cur.cal+"L"));
                    visited[cur.L()] = true;
                }
                if(!visited[cur.R()]){
                    q.add(new Register(cur.R(), cur.cal+"R"));
                    visited[cur.R()] = true; 
                }
            }
        }

        bw.flush();
        bw.close();

    }

    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static class Register{
        int n;
        String cal;

        public Register(int n, String cal){
            this.n = n;
            this.cal = cal;
        }

        public int D(){
            return 2*n%10000;
        }
        public int S(){
            return n == 0 ? 9999 : n-1;
        }
        public int L(){
            return n%1000*10+n/1000;
        }
        public int R(){
            return n/10 + n%10*1000;
        }
    }
    
}

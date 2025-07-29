import java.io.*;

public class Main{
    public static void main(String[] arga) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        String[] ssplit = s.split("\\*");
        String start = ssplit[0];
        String end = ssplit[1];

        for(int i=0; i<N ; i++){
            String st = br.readLine();
            if(st.length() >= start.length() + end.length() && st.startsWith(start)&&st.endsWith(end)){
                bw.write("DA\n");
            }else {
                bw.write("NE\n");
            }
        }
        bw.flush();
        bw.close();

    }
    
}

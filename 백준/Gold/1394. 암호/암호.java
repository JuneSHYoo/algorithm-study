import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine(); 
        String ans = br.readLine();

        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<len;i++){
            map.put(s.charAt(i),i+1);
        }

        int cnt = map.get(ans.charAt(0));
        int anslen = ans.length();
        for(int i=1; i<anslen; i++){
            char c = ans.charAt(i);
            cnt = (len * cnt + map.get(c)) % 900528;
            // cnt = cnt + map.get(c);

            // 2자리야
            // 한번 돌고 (26) + a를 선택하고 두번째 자리의 integer

            // bk
            // 한번 돌고 (26)  
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();

        // a b c d e f ...
        // aa ab ac ...
        // aaa aab aac aad ...


    }
    
}

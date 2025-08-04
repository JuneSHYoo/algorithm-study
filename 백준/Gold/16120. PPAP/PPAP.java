import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<s.length(); i++){
            if(s.charAt(i) == 'P'){
                stack.push('P');
            } else {
                if(stack.size() >= 2 && i != s.length() - 1 && s.charAt(i+1) == 'P'){
                    stack.pop();
                    stack.pop();
                    i++;
                    stack.push('P');
                }else {
                    bw.write("NP");
                    bw.flush();
                    return;
                }
            }
        }

        if(stack.size() ==1){
            bw.write("PPAP");
        }else{
            bw.write("NP");
        }
        bw.flush();
        bw.close();
    }
}

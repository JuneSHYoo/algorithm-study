import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<String> itemList = new ArrayList<>();

        for(int i=0; i<N ; i++){
            itemList.add(br.readLine());
        }

        Collections.sort(itemList, new Comparator<String>(){

            @Override
            public int compare(String str1, String str2){
                if(str1.length() == str2.length()){
                    int sum1 = sumNum(str1);
                    int sum2 = sumNum(str2);
                    if(sum1 == sum2){
                        return str1.compareTo(str2);
                    }else{
                        return sum1 - sum2;
                    }

                }else{
                    return str1.length() - str2.length();
                }

            }

            private int sumNum(String s){
                int sum = 0;
                for(int i=0; i<s.length() ; i++){
                    char ch = s.charAt(i);
                    if(Character.isDigit(ch)){
                        sum += ch - '0';
                    }
                }

                return sum;
            }


        });

        for(String s:itemList){
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
    
}

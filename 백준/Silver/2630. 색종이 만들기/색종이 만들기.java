import java.io.*;
import java.util.*;

public class Main {

    static int white = 0;
    static int blue = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N ;i++){
            board[i] = sToIArr(br.readLine());
        }

        partition(0,0,N);

        bw.write(String.valueOf(white)+"\n");
        bw.write(String.valueOf(blue)+"\n");
        
        bw.flush();
        bw.close();

    }

    public static void partition(int row, int col, int size){

        if(colorCheck(row, col, size)){
            if(board[row][col]== 0){
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int newSize = size/2;

        partition(row, col, newSize);
        partition(row+newSize, col, newSize);
        partition(row,col+newSize, newSize);
        partition(row+newSize, col+newSize, newSize);
    }

    public static boolean colorCheck(int row, int col, int size){
        int color = board[row][col]; //기준 색

        for(int i=row; i<row+size; i++){
            for(int j=col; j< col+size;j++){
                // 다른 색상 하나라도 있으면 false
                if(board[i][j] != color){
                    return false;
                }
            }
        }

        return true;
    }
    
    private static int[] sToIArr(String s){
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

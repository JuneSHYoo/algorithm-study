import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;
    
        Arrays.sort(phone_book);
        for(int i=0; i <len-1;i++){
            boolean stAns = phone_book[i+1].startsWith(phone_book[i]);
            if(stAns) return !answer;
        }
        return answer;
    }
}
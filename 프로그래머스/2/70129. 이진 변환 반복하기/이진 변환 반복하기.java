import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            for(char tmp : s.toCharArray()) {
                if(tmp == '0') answer[1] += 1;
            }
            
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            answer[0] += 1;
        }
        
        return answer;
    }
}
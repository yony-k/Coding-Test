import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int xNum = 0;
        int aNum = 0;
        
        char[] charArray = s.toCharArray(); 
        
        for(int i=0; i<charArray.length; i++) {
            char a = charArray[i];
            
            if(x == a) {
                xNum++;
            } else {
                aNum++;
            }
            
            if(xNum==aNum) {
                answer++;
                if(i!=charArray.length-1) x = charArray[i+1];
                xNum = 0;
                aNum = 0;
            }
        }
        
        if(xNum != aNum) answer++;
        
        return answer;
    }
}
import java.util.*;

class Solution {
    List<String> wordList = Arrays.asList("A", "E", "I", "O", "U");
    int answer = 0;
    boolean found = false;
    public int solution(String word) {
        dfs("",0,word);
        return answer;
    }
    
    public void dfs(String result, int dept, String word) {
        
        if(result.equals(word)) {
            found = true;
            return;
        }
  
        if(dept < 5) {
            for(int i=0; i<wordList.size(); i++) {
                answer++;
                dfs(result + wordList.get(i), dept + 1, word);
                if(found) break;
            }
        }
    }
}
import java.util.*;

class Solution {
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        
        boolean isExist = Arrays.asList(words).contains(target);
        if(!isExist) return 0;
        
        boolean[] visited = new boolean[words.length];
        
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        while(!q.isEmpty()) {
            
            int qSize = q.size();
            
            for(int i=0; i<qSize; i++) {
                String now = q.poll();

                if(now.equals(target)) return answer;

                for(int j=0; j<words.length; j++) {
                    if(visited[j] == false && canConvert(now, words[j])) {
                        q.add(words[j]);
                        visited[j] = true;
                    }
                }
            }
            answer++;
        }
        
        return answer;
    }
    
    public boolean canConvert(String now, String next) {
        int diff = 0;
        for(int i=0; i<now.length(); i++) {
            if(now.charAt(i) != next.charAt(i)) diff++;
        }
        return diff == 1;
    }

}
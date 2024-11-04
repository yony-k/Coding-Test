import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<>();
    
        for(int i=0; i<players.length; i++) map.put(players[i], i);
        
        for(int i=0; i<callings.length; i++) {
            String now = callings[i];
            int score = map.get(now);
            
            String tmp = players[score-1];
            players[score-1] = players[score];
            players[score] = tmp;
            
            map.put(players[score], score);
            map.put(players[score-1], score-1);
        }
        
        return players;
    }
}
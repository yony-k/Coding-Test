import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        List<String> list = Arrays.asList(friends);
        Map<String, int[]> give = new HashMap<>();
        Map<String, int[]> receive = new HashMap<>();
        Map<String, Integer> answer = new HashMap<>();
        
        for(String name : friends) {
            give.put(name, new int[friends.length+1]);
            receive.put(name, new int[friends.length+1]);
        }
        
        for(String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift, " ");
            String giveOne = st.nextToken();
            String receiveOne = st.nextToken();
            
            int[] tmp = null;
            
            int giveIdx = list.indexOf(giveOne);
            int receiveIdx = list.indexOf(receiveOne);
            
            tmp = give.get(giveOne);
            tmp[receiveIdx]++;
            
            tmp = receive.get(receiveOne);
            tmp[giveIdx]++;
        }
        
        for(int i=0; i<friends.length; i++) {
            int[] giveList = give.get(friends[i]);
            int[] receiveList = receive.get(friends[i]);
            
            giveList[friends.length] = Arrays.stream(giveList).sum();
            receiveList[friends.length] = Arrays.stream(receiveList).sum();
        }
        
        
        for(int i=0; i<friends.length; i++) {
            for(int j=i+1; j<friends.length; j++) {
                String iName = friends[i];
                String jName = friends[j];
                
                int[] iGiveList = give.get(iName);
                int[] iReceiveList = receive.get(iName);
                
                int[] jGiveList = give.get(jName);
                int[] jReceiveList = receive.get(jName);
                
                int iGive = iGiveList[j];
                int jGive = jGiveList[i];
                
                if(iGive > jGive) {
                    answer.put(iName, answer.getOrDefault(iName, 0) + 1);
                } else if(iGive < jGive) {
                    answer.put(jName, answer.getOrDefault(jName, 0) + 1);
                } else {
                    int iPoint = iGiveList[friends.length] - iReceiveList[friends.length];
                    int jPoint = jGiveList[friends.length] - jReceiveList[friends.length];
                    
                    if(iPoint > jPoint) {
                        answer.put(iName, answer.getOrDefault(iName, 0) + 1);
                    } else if(iPoint < jPoint) {
                        answer.put(jName, answer.getOrDefault(jName, 0) + 1);
                    } else {
                        continue;
                    }
                }
            }
        }
        
        int result = 0;
        
        for(String key : answer.keySet()) {
            int tmp = answer.get(key);
            result = result < tmp ? tmp : result;
        }

        return result;
    }
}
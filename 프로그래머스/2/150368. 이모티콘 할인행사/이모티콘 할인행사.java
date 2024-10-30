import java.util.*;

class Solution {
    int[] percent = {10,20,30,40};
    int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] r = new int[emoticons.length];
        
        dfs(r, emoticons, users, 0);

        return answer;
    }
    
    public void dfs(int[] result, int[] emoticons, int[][] users, int dept) {
        
        if(dept == emoticons.length) {
            List<Integer> list = new ArrayList<>();
            
            for(int i=0; i<emoticons.length; i++) {
                list.add(result[i]);
            }
            
            calculate(emoticons, users, list);
            
            return;
        }
        for(int i=0; i<4; i++) {
            result[dept] = percent[i];
            dfs(result, emoticons, users, dept+1);
        }
    }
    
    public void calculate(int[] emoticons, int[][] users, List<Integer> list) {
        
        int[] tmp = new int[2];
        
        for(int i=0; i<users.length; i++) {
            int percentUser = users[i][0];
            int bugetUser = users[i][1];

            int sum = 0;

            for(int j=0; j<list.size(); j++) {
                if(percentUser <= list.get(j)) {
                    sum += (emoticons[j] / 100) * (100 - list.get(j));
                }
            }

            if(sum >= bugetUser) tmp[0]++;
            else tmp[1] += sum;
        }

        if(tmp[0] > answer[0]) {
            answer[0] = tmp[0];
            answer[1] = tmp[1];
        } else if(tmp[0] == answer[0] && tmp[1] > answer[1]) {
            answer[1] = tmp[1];
        }
    }
}
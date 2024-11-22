import java.util.*;

class Solution {
    
    int[] moveX = {1,-1,0,0};
    int[] moveY = {0,0,-1,1};
    int[][] distance;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        distance = new int[maps.length][maps[0].length];
        
        bfs(maps);
        
        int target = distance[maps.length-1][maps[0].length-1];
        
        return answer = target != 0 ? target : -1;
    }
    
    public void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        distance[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int nowX = node[0];
            int nowY = node[1];
            
            for(int i=0; i<4; i++) {
                int nextX = node[0] + moveX[i];
                int nextY = node[1] + moveY[i];
                
                if(nextX >= maps.length || nextX < 0 || nextY >= maps[0].length || nextY < 0) {
                    continue;
                } 
                
                if(distance[nextX][nextY] == 0 && maps[nextX][nextY] == 1) {
                    distance[nextX][nextY] = distance[nowX][nowY] + 1;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
    }

}
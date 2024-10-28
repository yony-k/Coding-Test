import java.util.*;

class Solution {
    int[] moveX = {0, 0, 1, -1};
    int[] moveY = {1, -1, 0, 0};
    boolean[][] visited;
    
    public int solution(String[] maps) {
        int answer = -1;
        
        visited = new boolean[maps.length][maps[0].length()];
        
        int startX = 0;
        int startY = 0;
        
        for(int i=0; i<maps.length; i++) {
            String s = maps[i];
            if(s.contains("S")) {
                startX = s.indexOf("S");
                startY = i;
            }
        }
        
        Node findL = bfs(maps, "L", startX, startY);
        
        visited = new boolean[maps.length][maps[0].length()];

        Node findE = bfs(maps, "E", findL.x, findL.y);
        
        if(findL.dis != 0 && findE.dis !=0) answer = (findL.dis + findE.dis);
        
        return answer;
    }
    
    public Node bfs(String[] maps, String find, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited[y][x] = true;
        
        Node result = new Node(0,0,0);
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            
            char tmp = maps[nowY].charAt(nowX);

            if(find.equals(String.valueOf(tmp))) {            
                result = now;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int newX = nowX + moveX[i];
                int newY = nowY + moveY[i];
                
                if(newX < 0 || newX > maps[0].length()-1 || newY < 0 || newY > maps.length-1) continue;
                
                if(visited[newY][newX] == false) {
                    tmp = maps[newY].charAt(newX);
                    
                    if(tmp == 'X') continue;
                    else {
                        visited[newY][newX] = true;
                        q.add(new Node(newX, newY, now.dis+1));
                    }
                }
            }
        }
        
        return result;
    }
}

class Node {
    int x;
    int y;
    int dis;
    
    Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
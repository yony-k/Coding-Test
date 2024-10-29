class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int d) {
        
        answer = answer < d ? d : answer;
        
        for(int i=0; i<dungeons.length; i++) {
            int need = dungeons[i][0];
            int use = dungeons[i][1];
            
            if(!visited[i] && k >= need) {
                visited[i] = true;
                
                dfs(k-use, dungeons, d+1);
                
                visited[i] = false;
            }
        }
    }
}
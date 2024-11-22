class Solution {
    int answer = 0;
    boolean[] check;
    public int solution(int n, int[][] computers) {
        
        check = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!check[i]) { 
                answer++;
                dfs(computers, i); 
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int node) {
        check[node] = true;
        
        for(int i=0; i<computers.length; i++) {
            if(check[i] == false && computers[node][i] == 1) {
                dfs(computers, i);
            }
        }
    }
}
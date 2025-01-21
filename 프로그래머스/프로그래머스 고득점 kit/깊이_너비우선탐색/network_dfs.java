package 깊이_너비우선탐색;

import java.util.*;

class Solution {

    static boolean visited[];

    public void dfs(int start, int[][] computers, int n){
        visited[start] = true;

        for(int i = 0; i < n ; i++){
            if(visited[i]) continue;
            if(computers[start][i] == 1){
                dfs(i, computers, n);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            if(visited[i]) continue;
            dfs(i, computers, n);
            answer++;
        }
        return answer;
    }
}

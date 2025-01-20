package 깊이_너비우선탐색;

import java.util.*;

class Solution {

    static int answer;
    static boolean visited[];

    public void bfs(int[][] computers, int n, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int point = q.poll();
            visited[point] = true;
            for(int i = 0; i<n; i++){
                if(visited[i]) continue;
                if(computers[point][i] == 1){
                    q.add(i);
                }
            }
        }
        answer++;
    }
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            if(visited[i]) continue;
            bfs(computers, n , i);
        }
        return answer;
    }
}

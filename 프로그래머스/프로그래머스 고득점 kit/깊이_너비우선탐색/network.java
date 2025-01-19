package 깊이_너비우선탐색;

import java.util.*;

class Solution {

    static boolean visited[];
    static int answer;

    public void bfs(int[][] computers,int n, int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int point = q.poll();
            System.out.println(point);
            visited[point] = true;
            for(int i = 0; i<n; i++){
                if(visited[i]) continue;
                if(computers[point][i] == 1){
                    q.offer(i);
                }
            }
        }
        answer++;
    }

    public int solution(int n, int[][] computers) {
        answer = 0;
        visited=new boolean[n];

        for(int i = 0; i<visited.length; i++){
            if(visited[i]) continue;
            bfs(computers,n,i);
        }
        return answer;
    }
}

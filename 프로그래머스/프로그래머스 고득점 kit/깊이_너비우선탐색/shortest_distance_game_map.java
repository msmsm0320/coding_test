package 깊이_너비우선탐색;

import java.util.*;

class Solution {

    static int[] dx = {1,-1, 0, 0};
    static int[] dy = {0,0, 1, -1};
    static int[][] visited;

    public void bfs(int[][] maps, int x, int y){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = 1;

        while(!q.isEmpty()){
            int[] point = q.poll();
            int px = point[0];
            int py = point[1];

            for(int i = 0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 1 || nx > maps.length || ny < 1 || ny > maps[0].length || maps[nx-1][ny-1] == 0) continue;

                if(maps[nx-1][ny-1] == 1 && visited[nx][ny] == 0){
                    visited[nx][ny] = visited[px][py] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }

    public int solution(int[][] maps) {
        visited = new int[maps.length + 1][maps[0].length + 1];
        bfs(maps,1,1);

        int answer = visited[maps.length][maps[0].length];
        if(answer == 0) return -1;

        return answer;
    }
}
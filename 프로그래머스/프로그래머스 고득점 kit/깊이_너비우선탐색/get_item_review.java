import java.util.*;

class Solution {

    static int[][] map;
    static int[][] cost;
    static int SIZE;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public void fill(int[][] rectangle){ // 사각형의 테두리를 map에 표시

        for(int[] k : rectangle){
            int x1 = k[0]*2, x2 = k[2]*2;
            int y1 = k[1]*2, y2 = k[3]*2;

            for(int i = x1; i<=x2; i++){
                for(int j = y1; j<=y2; j++){
                    if(map[i][j] == 2) continue;
                    map[i][j] = 2; // 내부의 경우 2로설정
                    if(i == x1 || i == x2 || j == y1 || j == y2) map[i][j] = 1; // 테두리의 경우 1로 설정
                }
            }
        }
    }

    public int bfs(int startX, int startY, int endX, int endY){
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{startX, startY});
        cost[startX][startY] = 1;

        while(!q.isEmpty()){
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 102 || ny >= 102 || nx < 0 || ny < 0) continue;

                if(cost[nx][ny] == 0 && map[nx][ny] == 1) {
                    cost[nx][ny] = cost[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        return cost[endX][endY]/2;

    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        SIZE = 102;
        map = new int[SIZE][SIZE];
        cost = new int[SIZE][SIZE];

        fill(rectangle);
        int answer = bfs(characterX*2, characterY*2,itemX*2,itemY*2);

        return answer;


    }

}
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        map = new int[101][101];

        for (int[] r : rectangle)fill(2*r[0],2*r[1],2*r[2],2*r[3]); // 좌표 2배로 확장

        bfs(2*characterX,2*characterY,2*itemX,2*itemY);// BFS 실행

        return answer;
    }

    public void fill(int x1, int y1, int x2, int y2){

        for (int i = x1; i<=x2; i++){
            for (int j = y1; j<=y2; j++){

                if (map[i][j] == 2)continue; // 이미 내부를 2로 설정한 경우 pass

                map[i][j] = 2; // 내부의 경우 2로 설정

                if (i==x1||i==x2||j==y1||j==y2)map[i][j] = 1; // 직사각형의 테두리들은 1로 설정

            }
        }
    }

    public void bfs(int startX, int startY, int itemX, int itemY){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX,startY});
        int[][] cost = new int[101][101]; // 각 위치까지의 거리 배열
        cost[startX][startY] = 1; // 시작 위치 (거리 초기화)

        while (!q.isEmpty()){

            int[] move = q.poll();

            for (int i = 0; i < 4; i++){

                int moveX = move[0] + dx[i]; // 이동 가능한 경우 모두 확인
                int moveY = move[1] + dy[i];

                if (validation(moveX,moveY))continue; // 범위 벗어나면 스킵

                if (map[moveX][moveY] == 1 && cost[moveX][moveY] == 0){ // 테두리만 이동 가능 + 지나가지 않은 곳만 거리 확인

                    cost[moveX][moveY] = cost[move[0]][move[1]]+1; // 거리 업데이트
                    q.offer(new int[]{moveX, moveY});

                }
            }
        }

        answer = cost[itemX][itemY]/2; // 2배 확장했으므로 원래 크기로 변환
    }

    public boolean validation(int x, int y){

        return (0>x || 0>y || x>100 ||y>100); // 좌표가 범위 벗어날 경우 true 반환

    }
}
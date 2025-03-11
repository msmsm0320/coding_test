import java.util.*;

class Solution {

    // 상하좌우
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};


    public int solution(int[][] game_board, int[][] table) {

        // table, board의 방문 여부
        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];

        // board의 빈 공간, table의 퍼즐의 정보를 파악하기 위한 list
        List<List<int[]>> boardList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();

        // game_board 퍼즐 공간(0) 확인, table의 퍼즐(1) 확인
        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j< game_board.length; j++){

                if(table[i][j] == 1 && !visitedTable[i][j]){
                    bfs(i, j, visitedTable, table, 1, tableList);
                }

                if(game_board[i][j] == 0 && !visitedBoard[i][j]){
                    bfs(i, j, visitedBoard, game_board, 0, boardList);
                }
            }
        }
        return findBlock(boardList, tableList);
    }

    // 퍼즐 조각, 빈 공간 탐색
    public void bfs(int currentX, int currentY, boolean[][] visited, int[][] graph, int blockOrEmpty, List<List<int[]>> list){

        Queue<int[]> q = new LinkedList<>();
        visited[currentX][currentY] = true;
        q.add(new int[]{currentX, currentY});
        List<int[]> subList = new ArrayList<>(); // 퍼즐 조각을 상대 좌표(0,0) 기준으로 정리하는 List
        subList.add(new int[]{currentX - currentX, currentY - currentY}); // 상대 좌표의 기준은 (0,0)

        while(!q.isEmpty()){
            int[] point = q.poll();
            int pointX = point[0];
            int pointY = point[1];

            for(int i = 0; i<4; i++){
                int nX = pointX + dx[i];
                int nY = pointY + dy[i];

                if(nX < 0 || nX >= graph.length || nY < 0 || nY >= graph.length) continue;

                if(!visited[nX][nY] && graph[nX][nY] == blockOrEmpty){
                    visited[nX][nY] = true;
                    q.add(new int[]{nX, nY});
                    subList.add(new int[]{nX - currentX, nY - currentY});
                }
            }
        }
        list.add(subList);

    }
    // 퍼즐 공간과 퍼즐을 비교(조합)
    public int findBlock(List<List<int[]>> board, List<List<int[]>> table){

        int size = 0;
        int boardLen = board.size();
        boolean[] visitedBoard = new boolean[boardLen];

        for(List<int[]> tablePiece : table){
            for(int j = 0; j < boardLen; j++){
                List<int[]> boardSpace = board.get(j);

                // 빈 공간과 퍼즐의 size가 맞고, 아직 퍼즐 공간이 채워진 곳이 아니라면
                if(tablePiece.size() == boardSpace.size() && !visitedBoard[j]){
                    if (isRotate(boardSpace, tablePiece)){
                        size += tablePiece.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }
        return size;
    }

    // 회전 가능 여부 확인
    public boolean isRotate(List<int[]> board, List<int[]> table){

        boolean isMatched = false;

        board.sort((o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1],o2[1]) : Integer.compare(o1[0],o2[0]));

        for (int i = 0; i < 4; i++){

            table.sort((o1,o2) -> o1[0] == o2[0] ? Integer.compare(o1[1],o2[1]) : Integer.compare(o1[0],o2[0]));

            // 기준점 -> 첫 번째 퍼즐
            int baseX = table.get(0)[0];
            int baseY = table.get(0)[1];
            for (int j = 0; j< table.size(); j++){
                // 상대 좌표로 바꾸는 과정
                table.get(j)[0] -= baseX;
                table.get(j)[1] -= baseY;
            }

            // 동일한지 확인
            boolean isIdentical = true;
            for (int j = 0; j < board.size(); j++) {
                // 퍼즐의 좌표를 하나하나 확인해보면서 확인
                if (board.get(j)[0] != table.get(j)[0] || board.get(j)[1] != table.get(j)[1]){
                    isIdentical = false;
                    break;
                }
            }

            if(isIdentical){
                isMatched = true;
                break;
            } else {
                for(int j = 0; j < table.size(); j++) {
                    int temp = table.get(j)[0];
                    table.get(j)[0] = table.get(j)[1];
                    table.get(j)[1] = -temp;
                }
            }
        }

        return isMatched;
    }


}
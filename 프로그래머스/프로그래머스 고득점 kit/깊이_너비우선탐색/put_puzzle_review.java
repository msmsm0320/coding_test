import java.util.*;

class Solution {

    // x축 이동, Y축 이동 고려
    int[] dx = {-1, 0, 1 , 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {

        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];
        List<List<int[]>> boardList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();

        // game_board에서는 퍼즐이 들어갈 공간(0), table에서는 퍼즐 자체(1)를 찾는 과정
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {

                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    bfs(i, j, visitedTable, table, 1, tableList); // 퍼즐 블록 찾아서 tableList에 저장
                }

                if (game_board[i][j] == 0 && !visitedBoard[i][j]) {
                    bfs(i, j, visitedBoard, game_board, 0, boardList); // 빈 공간 찾아서 boardList에 저장
                }
            }
        }

        // 이 전에 찾은 퍼즐 공간, 퍼즐을 조합하는 과정
        return findBlock(boardList, tableList);
    }

    //퍼즐 공간과 퍼즐을 비교
    public int findBlock(List<List<int[]>> board, List<List<int[]>> table) {

        int size = 0;
        int boardLen = board.size();
        boolean[] visitedBoard = new boolean[boardLen];

        for (List<int[]> tablePiece : table) {
            for (int j = 0; j < boardLen; j++) {
                List<int[]> boardSpace = board.get(j);

                if (tablePiece.size() == boardSpace.size() && !visitedBoard[j]) { // 빈 공간 list에서 가져온 공간과 퍼즐의 size가 같고, 이미 맞춘 공간이 아니면 확인
                    if (isRotate(boardSpace, tablePiece)) {
                        size += tablePiece.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }

        return size;
    }

    public boolean isRotate(List<int[]> board, List<int[]> table) {

        boolean isMatched = false;


        // 정렬 과정 -> 원래의 퍼즐 모양 형태를 유지하기 위함

        // board의 x좌표를 비교하여 같으면 y좌표 비교 아닐경우 x좌표를 비교하여 정렬
        board.sort((o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));

        for (int i = 0; i < 4; i++) { // 4회 회전하며 비교

            // table의 x좌표를 비교하여 같으면 y좌표 비교 아닐경우 x좌표를 비교하여 정렬
            table.sort((o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));

            // 기준점을 첫번째 퍼즐로 맞춤
            int baseX = table.get(0)[0];
            int baseY = table.get(0)[1];
            for (int j = 0; j < table.size(); j++) { // 맨 처음 퍼즐도 (0,0)으로 기준이 맞춰지므로 이후엔 반복해도 영향 X
                table.get(j)[0] -= baseX;
                table.get(j)[1] -= baseY;
            }

            // 동일한지 확인
            boolean isIdentical = true;
            for (int j = 0; j < board.size(); j++) {
                if (board.get(j)[0] != table.get(j)[0] || board.get(j)[1] != table.get(j)[1]) { //
                    isIdentical = false;
                    break;
                }
            }

            if (isIdentical) {
                isMatched = true;
                break;
            } else {
                // 90도 회전
                for (int j = 0; j < table.size(); j++) {
                    int temp = table.get(j)[0];
                    table.get(j)[0] = table.get(j)[1];
                    table.get(j)[1] = -temp;
                }
            }
        }

        return isMatched;
    }

    // 퍼즐 조각, 빈 공간 탐색
    public void bfs(int currentX, int currentY, boolean[][] visited, int[][] graph, int blockOrEmpty, List<List<int[]>> list) {
// blockOrEmpty는 game_board의 경우 퍼즐을 넣을 수 있는 공간(빈 공간)이 0, table의 경우 퍼즐이 1로 표현
        Queue<int[]> queue = new LinkedList<>();
        visited[currentX][currentY] = true;
        queue.add(new int[]{currentX, currentY});
        List<int[]> subList = new ArrayList<>(); // 퍼즐 조각을 (0,0) 기준으로 정리하는 List
        subList.add(new int[]{0, 0}); // 상대 좌표 기준 0,0

        while (!queue.isEmpty()) {
            int[] pop = queue.poll();
            int popX = pop[0];
            int popY = pop[1];

            for (int i = 0; i < 4; i++) {
                int nextX = popX + dx[i];
                int nextY = popY + dy[i];

                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph.length) {
                    continue;
                }
                if (!visited[nextX][nextY] && graph[nextX][nextY] == blockOrEmpty) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    subList.add(new int[]{nextX - currentX, nextY - currentY}); // 상대좌표의 기준으로 current의 좌표로 잡았기 때문에 next-current
                }
            }
        }
        list.add(subList);
    }
}

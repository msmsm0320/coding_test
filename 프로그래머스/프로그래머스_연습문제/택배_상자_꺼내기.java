class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int floor = n / w;
        if (n % w > 0) floor++; // 나머지 상자가 있으면 한 층 더 필요

        int box = 1;
        int[][] garage = new int[floor][w];

        // 상자 배치
        for (int i = 0; i < floor; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w && box <= n; j++) {
                    garage[i][j] = box++;
                }
            } else {
                for (int j = w - 1; j >= 0 && box <= n; j--) {
                    garage[i][j] = box++;
                }
            }
        }

        // num 위치 찾기
        int row = -1, col = -1;
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < w; j++) {
                if (garage[i][j] == num) {
                    row = i;
                    col = j;
                    break;
                }
            }
            if (row != -1) break;
        }

        // 해당 열 위쪽 상자 개수 세기
        for (int i = row; i < floor; i++) {
            if (garage[i][col] != 0) {
                answer++;
            }
        }

        return answer;
    }
}

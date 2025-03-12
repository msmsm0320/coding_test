import java.util.*;

class Solution {
    public int solution(String[] arr) {
        int n = arr.length / 2 + 1; // 숫자의 개수
        int[][] maxDP = new int[n][n];
        int[][] minDP = new int[n][n];

        // 숫자 배열 초기화
        for (int i = 0; i < n; i++) {
            maxDP[i][i] = Integer.parseInt(arr[i * 2]);
            minDP[i][i] = Integer.parseInt(arr[i * 2]);
        }

        // DP 테이블 채우기 (길이 2 이상인 구간)
        for (int len = 1; len < n; len++) { // 길이: 2 ~ n까지
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;

                // i부터 j까지 탐색하면서 k를 기준으로 분할
                for (int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1]; // 연산자
                    if (op.equals("+")) {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k+1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k+1][j]);
                    } else { // "-"
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k+1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k+1][j]);
                    }
                }
            }
        }

        return maxDP[0][n - 1]; // 전체 구간의 최댓값 반환
    }
}

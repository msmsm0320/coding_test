import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];
        int answer = 0;
        // 그래프 생성(이기면 1, 지면 -1)
        for(int i = 0; i<results.length; i++){
            graph[results[i][0]][results[i][1]] = 1;
            graph[results[i][1]][results[i][0]] = -1;
        }
        // 시작
        for(int i =1; i<=n; i++){
            // 끝
            for(int j = 1; j<=n; j++){
                // 중간 경유
                for(int k = 1; k<=n; k++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }

                    if(graph[i][k] == -1 && graph[k][j] == -1){
                        graph[i][j] = -1;
                        graph[j][i] =1;
                    }
                }
            }
        }

        for(int i = 1; i<=n; i++){
            int count = 0;
            for(int j = 1; j<=n; j++){
                if(graph[i][j] != 0 ) count++;
            }
            if(count == (n-1)) answer++;
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        // triangle을 순회 하며 초기화, i는 층, j는 위치
        for(int i = 1; i<triangle.length; i++){
            for(int j = 0; j<triangle[i].length; j++){
                // 가장 왼쪽
                if(j == 0) triangle[i][j] += triangle[i-1][j];
                    // 가장 오른쪽
                else if(j == i) triangle[i][j] += triangle[i-1][j-1];
                    // 평범한 경우
                else triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }
        for(int k : triangle[triangle.length-1]){
            answer = Math.max(k,answer);
        }
        return answer;
    }
}
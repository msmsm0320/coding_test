import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i =1; i<triangle.length; i++){
            for(int j = 0; j<triangle[i].length; j++){
                if(j == 0 ) triangle[i][j] += triangle[i-1][j]; // 왼쪽 끝
                else if(j == i) triangle[i][j] += triangle[i-1][j-1]; // 오른쪽 끝
                else triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }

        for(int k : triangle[triangle.length-1]){
            answer = Math.max(answer,k);
        }
        return answer;
    }
}

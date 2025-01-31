import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        // 진출이 큰 수부터 오름차순으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(a->a[1]));

        int min = -30000;
        int lastCameraLocation = routes[0][1];
        // 배열 순회하며 진입 위치가 lastCameraLocation 보다 멀리 있으면, lastCameraLocation 위치를 해당 차량의 진출로 바꿈(answer++)
        for(int i = 0; i<routes.length; i++){
            int entry = routes[i][0];
            int exit = routes[i][1];

            if(lastCameraLocation < entry){
                lastCameraLocation = exit;
                answer++;
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int lastCameraPosition = Integer.MIN_VALUE;

        for(int[] route : routes){
            int entry = route[0];
            int exit = route[1];

            if(lastCameraPosition < entry){
                answer++;
                lastCameraPosition = exit;
            }
        }
        return answer;
    }
}
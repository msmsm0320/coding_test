import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 오름차순 정렬
        Arrays.sort(times);
        // high 는 times에서 가장 큰 값 * n(가장 오래 걸림을 가정), low 는 1로 설정
        long high = (long) times[times.length - 1]*n;
        long low = 1;

        while(low <= high){
            long mid = (low + high) / 2;
            long count = 0;
            // mid 시간 동안 심사관들이 얼마나 해결할 수 있나 확인
            for(long time : times){
                count += mid/time;
            }

            if(count >= n){
                answer = mid;
                high = mid -1;
            } else low = mid +1;
        }

        return answer;
    }
}
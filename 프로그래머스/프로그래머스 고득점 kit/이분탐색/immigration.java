import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length-1]*n;

        // left > right 될 때까지 mid(정답 유츄) 탐지
        while(left <= right){
            long mid = (left + right)/2;
            long fin = 0;
            for(int time : times){
                fin += mid/time;
                if(fin >= n) break;
            }
            if(fin >= n) {
                answer = mid;
                right = mid-1;
            }
            else left = mid +1;
        }
        return answer;
    }
}
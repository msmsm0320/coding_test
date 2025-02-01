import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);
        int left = 1;
        int right = distance;

        while(left <= right){
            int mid = (left + right)/2;
            int removedStones = 0;
            int prev = 0; // 이전 돌 위치

            for(int rock : rocks){
                if(rock - prev < mid){ // 현재 돌과 이전 돌 사이가 mid보다 작으면 제거
                    removedStones++;
                } else{
                    prev = rock;
                }
            }
            if(distance - prev < mid){
                removedStones++;
            }

            if(removedStones <= n){
                answer = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return answer;
    }
}
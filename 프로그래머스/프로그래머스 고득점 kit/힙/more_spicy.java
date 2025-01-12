import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }


        while(pq.size() > 1 && pq.peek() < K){
            int first = pq.poll();
            int second = pq.poll();

            int mixFood = first + (second * 2);

            pq.offer(mixFood);
            answer++;

            if(pq.size() < 2 && pq.peek()<K){
                return -1;
            }
        }

        return answer;
    }
}
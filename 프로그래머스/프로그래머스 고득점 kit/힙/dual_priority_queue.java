import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());

        for(String op : operations){
            if(op.startsWith("D 1")){
                min_pq.remove(max_pq.peek());
                max_pq.poll();

            }else if(op.startsWith("D -1")){
                max_pq.remove(min_pq.peek());
                min_pq.poll();
            }else{
                int num = Integer.parseInt(op.substring(2));
                min_pq.add(num);
                max_pq.add(num);
            }
        }

        if(!min_pq.isEmpty() && !max_pq.isEmpty()){
            answer[0] = max_pq.poll();
            answer[1] = min_pq.poll();
        }
        return answer;
    }
}
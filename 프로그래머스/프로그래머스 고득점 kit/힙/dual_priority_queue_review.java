import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> pq_Min = new PriorityQueue<>();
        PriorityQueue<Integer> pq_Max = new PriorityQueue<>(Collections.reverseOrder());


        for( String op : operations){
            if(op.startsWith("D -1")){
                pq_Max.remove(pq_Min.peek());
                pq_Min.poll();
            }else if(op.startsWith("D 1")){
                pq_Min.remove(pq_Max.peek());
                pq_Max.poll();
            }else{
                int num = Integer.parseInt(op.substring(2));
                pq_Min.offer(num);
                pq_Max.offer(num);
            }
        }

        int answer[] = {0,0};
        if(!pq_Max.isEmpty() && !pq_Min.isEmpty()){

            answer[0] = pq_Max.poll();
            answer[1] = pq_Min.poll();
        }
        return answer;
    }
}
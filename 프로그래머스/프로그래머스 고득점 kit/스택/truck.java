import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        int i =0;

        for (i =0; i<bridge_length;i++){
            q.add(0);
        }
        i = 0;

        while(i < truck_weights.length || sum > 0){
            sum -= q.remove();
            if(i<truck_weights.length && sum + truck_weights[i] <= weight){
                q.add(truck_weights[i]);
                sum+=truck_weights[i];
                i++;
            } else{
                q.add(0);
            }
            answer++;
        }
        return answer;
    }
}

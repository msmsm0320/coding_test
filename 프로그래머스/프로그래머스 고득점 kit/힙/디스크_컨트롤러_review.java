import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs,(a,b) -> (a[0] - b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));

        int count = 0;
        int end = 0;
        int index = 0;

        while(count < jobs.length){
            while(index<jobs.length && jobs[index][0] <=end){
                pq.add(jobs[index++]);
            }

            if(pq.isEmpty()){
                end = jobs[index][0];
            }else{
                int temp[] = pq.poll();
                count++;
                answer += temp[1] + end -temp[0];
                end += temp[1];
            }
        }

        return answer/count;
    }
}
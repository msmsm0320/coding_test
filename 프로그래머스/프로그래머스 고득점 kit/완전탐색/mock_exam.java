import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;


        int[] pattern_1 = {1, 2, 3, 4, 5};
        int[] pattern_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        Queue<Integer> q_1 = new LinkedList<>();
        Queue<Integer> q_2 = new LinkedList<>();
        Queue<Integer> q_3 = new LinkedList<>();

        for (int p : pattern_1) q_1.offer(p);
        for (int p : pattern_2) q_2.offer(p);
        for (int p : pattern_3) q_3.offer(p);


        for (int a : answers) {
            if (q_1.peek() == a) count_1++;
            q_1.offer(q_1.poll());

            if (q_2.peek() == a) count_2++;
            q_2.offer(q_2.poll());

            if (q_3.peek() == a) count_3++;
            q_3.offer(q_3.poll());
        }


        int[] scores = {count_1, count_2, count_3};
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));


        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }

        int index = 0;

        int answer[] = new int[result.size()];
        for(int k : result){
            answer[index++] = k;
        }
        return answer;
    }
}

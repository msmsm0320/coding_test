public class feature_improvement_review {
    import java.util.Stack;

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            int answer[] = new int[progresses.length];
            int remain_day[] = new int[progresses.length];
            int i, j,currentMax, day;


            for(i = 0; i<progresses.length; i++){
                remain_day[i] = (100-progresses[i])/speeds[i];
                if((100-progresses[i])%speeds[i] >0 ) {
                    remain_day[i] += 1;
                }

            }

            currentMax=0;
            j =0;
            day =1;
            for(i=1; i<remain_day.length; i++){
                if(remain_day[currentMax]>=remain_day[i]){
                    day++;
                }else{
                    currentMax = i;
                    answer[j++] = day;
                    day = 1;
                }

            }
            answer[j++] = day;

            int result[] = new int[j];
            for(i = 0; i<j; i++){
                result[i] = answer[i];
            }
            return result;
        }
    }
}

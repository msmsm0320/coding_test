import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> days = new Stack<>();
        int remainingday;

        for(int i = progresses.length-1; i>=0; i--){
            remainingday = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]>0){
                remainingday++;
            }
            stack.push(remainingday);
        }

        while(!stack.isEmpty()){
            int day =1;
            int currentMax = stack.pop();
            while(!stack.isEmpty() && currentMax >=stack.peek()){
                stack.pop();
                day++;
            }
            days.push(day);
        }
        int[] answer = new int [days.size()];
        for(int j=days.size() -1 ;j>=0;j--){
            answer[j]=days.pop();
        }
        return answer;
    }
}
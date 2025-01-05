import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length -1]);

        for(int i = arr.length-2; i>=0; i--){
            if(!st.peek().equals(arr[i])){
                st.push(arr[i]);
            }
        }

        int[] answer = new int[st.size()];
        int j =  0;
        while(!st.isEmpty()){
            answer[j++] = st.pop();
        }
        return answer;
    }
}
public class correct_parentheses_review {
    import java.util.*;

    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            int count = 0;
            Queue q = new LinkedList();

            for(int i = 0; i<s.length(); i++){
                q.add(s.charAt(i));
            }

            while(!q.isEmpty()){
                if(q.remove().equals(')')){
                    count--;
                    if(count <0){
                        answer = false;
                        return answer;
                    }
                }else{
                    count++;
                }
            }
            return count == 0;
        }

    }

}

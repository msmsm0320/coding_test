import java.util.*;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numtostr = new String[numbers.length];

        for(int i = 0; i<numbers.length; i++){
            numtostr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numtostr,(s1  , s2) -> (s2 + s1).compareTo(s1 + s2));

        for(String str : numtostr){
            answer += str;
        }

        if(answer.charAt(0) == '0'){
            answer ="0";
        }

        return answer;
    }
}
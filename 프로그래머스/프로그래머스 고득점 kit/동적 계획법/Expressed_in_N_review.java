import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> dp = new ArrayList<>();

        // N을 사용한 횟수 1~8까지 List에 Set 생성
        for(int i = 0; i<=8; i++){
            dp.add(new HashSet());
        }

        // NN, NNN ... 숫자 list에 삽입
        for(int i = 1; i<=8; i++){
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(num);

            // List, Set에 실제 값 저장
            for(int j=1; j< i; j++){
                for (int num1 : dp.get(j)){
                    for(int num2 : dp.get(i-j)){
                        dp.get(i).add(num1+num2);
                        dp.get(i).add(num1-num2);
                        dp.get(i).add(num1*num2);
                        if(num2 != 0) dp.get(i).add(num1/num2);
                    }
                }
            }
            if(dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1; // N 자체가 number이면 바로 반환

        // 1~8개까지 사용해서 만들 수 있는 숫자를 저장할 DP 배열
        List<Set<Integer>> dp = new ArrayList<>();

        // 초기화: dp[i]를 위한 빈 HashSet을 생성
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // N을 1~8번 사용해서 만들 수 있는 숫자들을 저장
        for (int i = 1; i <= 8; i++) {
            // 같은 숫자를 이어붙인 값 (예: N=5 → 5, 55, 555, 5555 ...)
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(num);

            // j와 i-j 조합을 이용하여 숫자 만들기
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) dp.get(i).add(num1 / num2);
                    }
                }
            }

            // 목표 숫자가 있으면 정답 반환
            if (dp.get(i).contains(number)) return i;
        }

        return -1; // 8번 초과로 만들 수 없으면 -1 반환
    }
}

package 깊이_너비우선탐색;

import java.util.*;

class Solution {

    static  int answer;
    static int  count;
    public void dfs(int[] numbers, int target, int check, int depth){
        if(check == target && depth == numbers.length){
            answer++;
            return;
        }

        if(depth == numbers.length){
            return;
        }

        int check_p = check + numbers[depth];
        int check_n = check - numbers[depth];

        dfs(numbers, target, check_p, depth + 1);
        dfs(numbers, target, check_n, depth + 1);

    }

    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, target, 0, 0);
        return answer;
    }
}

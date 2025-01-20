package 깊이_너비우선탐색;

import java.util.*;

class Solution {

    static int answer;

    public void dfs(int[] numbers, int target, int depth, int check){
        if(depth == numbers.length){
            if(check == target){
                answer++;
                return;
            }
            return;
        }

        check += numbers[depth];
        dfs(numbers, target, depth+1, check);
        check -= 2*numbers[depth];
        dfs(numbers, target, depth+1, check);
    }
    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, target, 0, 0);

        return answer;
    }
}

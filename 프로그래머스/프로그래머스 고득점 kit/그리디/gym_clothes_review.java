import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // lost, reserve 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // lost 학생 중 reserve 포함 -> lost, reserve에서 제거
        for(int i = 0; i< lost.length; i++){
            for(int j = 0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // reserve 배열 순회 +-1 하면서 lost 포함 되어 있으면 lost에서 삭제
        for(int i = 0; i<reserve.length; i++){
            for(int j = 0; j<lost.length; j++){
                if(lost[j] == reserve[i] -1 || lost[j] == reserve[i] + 1) {
                    lost[j] = -1;
                    reserve[i] = -1;
                }
            }
        }

        // lost 학생 수 반환
        for(int k : lost){
            if(k > 0) answer--;
        }
        return answer + n;
    }
}
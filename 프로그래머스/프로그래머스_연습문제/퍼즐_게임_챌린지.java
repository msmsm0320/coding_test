class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int high = 0;
        int low = 1;
        // 이분탐색으로 풀이
        for(int i = 0; i<diffs.length; i++){ // 각각 low
            high = Math.max(high, diffs[i]);
        }
        while(low <= high){
            int mid = (low + high)/2; // level 설정
            int level = mid;
            long timeCount = 0; // 퍼즐 푸는 총 시간
            for(int j =0; j<diffs.length; j++){
                if(diffs[j] <= level) timeCount += times[j]; // level이 숙련도 이상이면 해당 diff 시간만 추가
                else{// level이 숙련도 미만이면 숙련도 차이 * (이 전 퍼즐의 걸리는 시간들의 총합 + 현재 퍼즐 걸리는 시간) + 현재 퍼즐 걸리는 시간
                    if(j == 0) timeCount += (long) (diffs[j] - level) * (long)(times[j]) + times[j];
                    else{
                        timeCount += (long) (diffs[j] - level)* (long)(times[j] + times[j-1])  + times[j];
                    }
                }
            }
            // 퍼즐 총 풀이 시간이 limit 이하 일 경우 -> high = mid -1; (시간이 남기 때문에 숙련도 최소 값을 낮춤)
            if(timeCount <= limit){
                answer = mid;
                high = mid-1;
            } else{// 퍼즐 총 풀이 시간이 limit 보다 클 경우 -> low = mid +1; (시간이 부족 하기 때문에 숙련도 최소 값을 늘림)
                low = mid+1;
            }
        }

        return answer;
    }
}
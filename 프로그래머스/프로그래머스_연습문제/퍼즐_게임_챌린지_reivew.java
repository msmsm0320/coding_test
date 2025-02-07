class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        // 이분 탐색으로 접근
        int low = 1;
        int high = 0;

        // high 값은 diffs 중 가장 큰 값
        for(int diff : diffs){
            high = Math.max(high, diff);
        }

        // low가 high를 넘을 때 까지 이분 탐색 시작
        while(low <= high){
            // 임시 숙련도 최솟값 mid 지정
            int mid = (low+high)/2;
            long timeCount = 0; // 퍼즐을 다 완료 했을 때, 시간

            for(int i = 0; i<diffs.length; i++){
                if(mid >= diffs[i]){ // mid가 숙련도 보다 높거나 같을 경우 현재 퍼즐 시간만 더해짐
                    timeCount += times[i];
                }else{ // mid가 숙련도보다 낮을 경우
                    if(i == 0){ // 맨 처음 경우
                        timeCount += (long) (diffs[i] - mid)*(long)(times[i]) + times[i];
                    }else{ // 일반 적인 경우
                        timeCount += (long) (diffs[i] - mid)*(long)(times[i-1] + times[i]) + times[i];
                    }
                }
            }
            // timeCount가 limit 보다 작거나 같은 경우 숙련도를 더 작게 할 수 있기 때문에 high 더 작게
            if(timeCount <= limit){
                answer = mid;
                high = mid -1;
            }else{
                low = mid +1;
            }

        }
        return answer;
    }
}
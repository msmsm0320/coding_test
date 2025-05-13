class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i = 0; i<schedules.length; i++){
            int goalHour = schedules[i] / 100;
            int goalMinute = schedules[i] % 100;
            int goalTime = (goalHour * 60) + goalMinute + 10;

            int currentDay = startday;

            Boolean gift = true;

            for(int j = 0; j<timelogs[i].length; j++){
                if(currentDay != 6 && currentDay != 7){
                    int hour = timelogs[i][j] / 100;
                    int minute = timelogs[i][j] % 100;
                    int time = (hour*60) + minute;

                    if(time > goalTime) gift = false;
                }
                currentDay = (currentDay%7) + 1;
            }
            if(gift) answer++;
        }

        return answer;
    }
}
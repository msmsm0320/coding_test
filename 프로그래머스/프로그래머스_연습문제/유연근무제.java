class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i = 0; i<schedules.length; i++){
            int hours = schedules[i]/100 * 60;
            int minutes = schedules[i]%100;

            int time = hours + minutes + 10;

            boolean gift = true;
            int currentday = startday;
            for(int j = 0; j<7; j++){
                if(currentday != 6 && currentday != 7){
                    int dayHours = timelogs[i][j]/100 * 60;
                    int dayMinutes = timelogs[i][j]%100;
                    int dayTime = dayHours + dayMinutes;

                    if(time < dayTime){
                        gift = false;
                        break;
                    }
                }
                currentday = (currentday % 7) + 1;
            }
            if(gift) answer++;
        }

        return answer;
    }
}
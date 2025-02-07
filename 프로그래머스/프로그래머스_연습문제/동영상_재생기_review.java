class Solution {
    public int trans60(String time){
        String[] trans = time.split(":");
        int minute = Integer.parseInt(trans[0]) * 60;
        int second = Integer.parseInt(trans[1]);
        return minute + second;
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 결과 return 할 StringBuilder 생성
        StringBuilder sb = new StringBuilder();

        // 각 argument mm : ss -> 초로 전부 변환
        int v_len = trans60(video_len);
        int position = trans60(pos);
        int start = trans60(op_start);
        int end = trans60(op_end);

        // commands 순환 하며 명령 수행
        for(String command : commands){
            // 현재 위치가 오프닝 구간에 있는 경우 현재 위치를 op_end로 설정
            if(position >= start && position <= end){
                position = end;
            }

            // prev 명령 수행
            if(command.equals("prev")){
                if(position -10 < 0){ // 현재 위치에서 10초 전으로 돌렸을 때, 0 보다 작은 경우
                    position = 0;
                }else{
                    position -= 10; // 나머지 경우
                }
            }else{
                if(position+10 > v_len){
                    position = v_len;
                }else{
                    position += 10;
                }
            }
            // 명령 수행 후, 현재 위치가 오프닝 구간에 있으면 현재 위치를 op_end로 설정
            if(position >= start && position <= end){
                position = end;
            }
        }

        // 명령 수행 후 위치를 다시 "mm : ss" 형태로 변환
        int minute = position/60;
        int second = position%60;

        if(minute < 10){
            sb.append("0").append(String.valueOf(minute));
        }else if(minute == 0){
            sb.append("00");
        }else{
            sb.append(String.valueOf(minute));
        }

        sb.append(":");
        if(second < 10){
            sb.append("0").append(String.valueOf(second));
        }else if(second == 0){
            sb.append("00");
        }else{
            sb.append(String.valueOf(second));
        }

        return sb.toString();

    }
}
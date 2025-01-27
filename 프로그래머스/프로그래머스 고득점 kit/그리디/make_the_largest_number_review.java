import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int numLength = number.length() - k;

        while(sb.length() < numLength){//Max 값 찾아서 StringBuilder에 삽입
            int max = -1;
            for(int i = index; i<=k+sb.length(); i++){ // 범위 안에서 Max 값 찾기 + Max index 지정
                if(max < number.charAt(i) - '0'){
                    max = number.charAt(i) -'0';
                    index =i+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
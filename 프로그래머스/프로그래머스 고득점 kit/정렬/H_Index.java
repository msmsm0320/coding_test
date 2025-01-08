import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int temp[] = citations;
        Arrays.sort(temp);


        for (int i =0; i<temp.length;i++){
            int h= temp.length - i;
            if(temp[i] >=h){answer = h;
                break;}
        }

        return answer;
    }
}
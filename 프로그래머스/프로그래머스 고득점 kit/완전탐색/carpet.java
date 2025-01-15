class Solution {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;
        int w = 0;
        int h = 0;
        int[] answer = new int[2];
        for(int i = total; i>2; i--){
            if(total % i != 0) continue;
            else{
                if(yellow == (i-2) * (total/(i)-2)){
                    w = i;
                    h = total/i;
                    answer[0] = w;
                    answer[1] = h;

                    return answer;
                }
            }
        }
        return answer;
    }
}
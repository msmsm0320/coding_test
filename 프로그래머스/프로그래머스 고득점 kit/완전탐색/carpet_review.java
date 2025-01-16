class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};

        int total= brown + yellow;

        for(int i = total; i>2; i--){
            if((i-2) * ((total/i)-2) == yellow){
                return new int[] {i,total/i};
            }
        }
        return answer;
    }
}
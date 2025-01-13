class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int W_max = 0;
        int H_max = 0;

        for(int[] s : sizes){
            if(s[0] <s[1]){
                int temp = s[0];
                s[0] = s[1];
                s[1] = temp;
            }
            if(W_max <= s[0]){
                W_max = s[0];
            }
            if(H_max <= s[1]){
                H_max = s[1];
            }
        }
        System.out.println(W_max);
        System.out.println(H_max);
        answer = W_max * H_max;
        return answer;
    }
}
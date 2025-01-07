class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count =0;

        for(int i = 0; i<prices.length; i++){
            for(int j= i+1; j<=prices.length-1; j++){
                count++;
                if(prices[i] >prices[j]){
                    break;
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }
}
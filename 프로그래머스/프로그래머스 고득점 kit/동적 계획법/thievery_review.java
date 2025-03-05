class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;

        // 첫 번째 집을 반드시 터는 경우
        int[] firstHouse = new int[N];
        firstHouse[0] = money[0];
        firstHouse[1] = money[0];

        for(int i = 2; i<N-1; i++){
            firstHouse[i] = Math.max(money[i]+firstHouse[i-2], firstHouse[i-1]);
        }
        // 첫 번째 집을 안 터는 경우
        int[] lastHouse = new int[N];
        lastHouse[0] = 0;
        lastHouse[1] = money[1];

        for(int i = 2; i<N; i++){
            lastHouse[i] = Math.max(money[i]+lastHouse[i-2], lastHouse[i-1]);
        }


        return Math.max(firstHouse[N-2],lastHouse[N-1]);
    }
}
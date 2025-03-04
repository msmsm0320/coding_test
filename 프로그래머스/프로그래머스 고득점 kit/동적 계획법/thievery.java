class Solution {
    public int solution(int[] money) {
        int n = money.length;
        if (n == 3){
            return Math.max(money[0], Math.max(money[1],money[2]));

        }

        int[] firstHouse = new int[n];
        firstHouse[0] = money[0];
        firstHouse[1] = money[0];
        for (int i = 2; i<n-1; i++){
            firstHouse[i] = Math.max(firstHouse[i-1], firstHouse[i-2] + money[i]);
        }

        int[] lastHouse = new int[n];
        lastHouse[0] = 0;
        lastHouse[1] = money[1];
        for(int i = 2; i<n; i++){
            lastHouse[i] = Math.max(lastHouse[i-1], lastHouse[i-2] + money[i]);
        }

        return Math.max(firstHouse[n - 2], lastHouse[n-1]);
    }
}
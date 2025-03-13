class Solution {
    int[][] maxDP;
    int[][] minDP;

    public int solution(String arr[]) {
        int numLen = arr.length / 2 + 1;
        maxDP = new int[numLen][numLen];
        minDP = new int[numLen][numLen];

        for (int i = 0; i < numLen; i++) {
            maxDP[i][i] = Integer.parseInt(arr[i * 2]);
            minDP[i][i] = Integer.parseInt(arr[i * 2]);
        }

        for (int len = 1; len < numLen; len++) {
            for (int i = 0; i < numLen - len; i++) {
                int j = i + len;
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];

                    if (op.equals("+")) {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j]);
                    } else { // "-"
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k + 1][j]);
                    }
                }
            }
        }

        return maxDP[0][numLen - 1];
    }
}

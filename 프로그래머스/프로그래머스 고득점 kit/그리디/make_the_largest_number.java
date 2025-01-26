import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int numLength = number.length() - k;

        while (sb.length() < numLength) {
            int max = -1;

            for (int j = index; j <= k + sb.length(); j++) {
                int num = number.charAt(j) - '0';
                if (num > max) {
                    max = num;
                    index = j + 1;
                }
            }

            sb.append(max);
        }

        return sb.toString();
    }
}

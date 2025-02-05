import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ", -1); // 연속된 공백 유지

        for (int w = 0; w < words.length; w++) {
            for (int i = 0; i < words[w].length(); i++) {
                if (i % 2 == 0) {
                    sb.append(Character.toUpperCase(words[w].charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(words[w].charAt(i)));
                }
            }

            // 마지막 단어 뒤에는 공백 추가 X
            if (w < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

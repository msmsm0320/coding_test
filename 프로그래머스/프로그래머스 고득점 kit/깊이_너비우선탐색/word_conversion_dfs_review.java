import java.util.*;

class Solution {

    static int answer;

    public boolean checkword(String begin, String word){
        int count = 0;

        for(int i = 0; i< begin.length(); i++){
            if(begin.charAt(i) != word.charAt(i)) count++;
            if(count>1) return false;
        }

        return count == 1;

    }

    public void bfs(String begin, String target, String[] words){
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        int count = 0;

        q.offer(begin);
        hs.add(begin);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String point = q.poll();

                if(point.equals(target)){
                    answer = count;
                    return;
                }

                for(int j = 0; j<words.length; j++){
                    if(hs.contains(words[j])) continue;
                    if(checkword(point,words[j])){
                        q.offer(words[j]);
                        hs.add(words[j]);
                    }
                }
            }
            count++;
        }
    }
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        bfs(begin, target, words);
        return answer;
    }
}
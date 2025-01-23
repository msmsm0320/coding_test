import java.util.*;

class Solution {

    static int answer;

    public boolean findword(String begin, String word){
        int count = 0;
        for(int i = 0; i<begin.length(); i++){
            if(begin.charAt(i) != word.charAt(i)){
                count++;

                if(count > 1) return false;
            }
        }
        return true;
    }
    public void bfs(String begin, String target, String[] words){
        int count = 0;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.add(begin);
        visited.add(begin);

        while(!q.isEmpty()){
            for(int i = 0; i<q.size(); i++){
                String point = q.poll();
                if(point.equals(target)){
                    answer = count;
                    return;
                }
                for (int j = 0; j<words.length; j++){
                    if(visited.contains(words[j]) || !findword(point, words[j])) continue;
                    q.offer(words[j]);
                    visited.add(words[j]);
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
package 깊이_너비우선탐색;

class Solution {

    static boolean[] visited;
    static int answer;

    public boolean findword(String begin, String word){
        int count = 0;
        for(int i = 0; i<begin.length(); i++){
            if(begin.charAt(i) == word.charAt(i)){
                count++;
            }
        }
        return begin.length() == count+1 ? true : false;
    }

    public void dfs(String begin, String target, String[] words, int count){

        if(begin.equals(target)){
            answer = count;
            return;
        }

        count++;
        for(int i =0; i<words.length; i++){
            if(visited[i]) continue;

            if(findword(begin, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, count);
                visited[i] = false;
            }

        }
    }
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
}
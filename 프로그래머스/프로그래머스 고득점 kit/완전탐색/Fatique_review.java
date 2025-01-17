import java.util.*;

class Solution {

    static List<String> list = new ArrayList<>();
    static boolean visited[] = new boolean[8];

    public void permute(int [][]dungeons, String str, int depth){
        if(depth == dungeons.length){
            list.add(str);
            return;
        }
        for(int i =0; i<dungeons.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                String s = str + i;
                permute(dungeons, s, depth+1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        permute(dungeons, "", 0);

        for(String s : list){
            int j = k;
            int count = 0;
            for(int i = 0; i< s.length(); i++){
                if(j>=dungeons[s.charAt(i) -'0'][0]){
                    j-= dungeons[s.charAt(i) -'0'][1];
                    count++;
                }
            }
            answer = Math.max(answer,count);
        }

        return answer;
    }
}
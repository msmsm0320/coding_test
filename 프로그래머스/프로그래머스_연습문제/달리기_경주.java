import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        // 등수 저장 HashMap
        HashMap<String,Integer> rank = new HashMap<>();

        for(int i = 0; i<players.length; i++){
            rank.put(players[i],i); // 등수는 배열로 저장 할 것이기 때문에 index 0부터 지정
        }

        // callings 배열 순회
        for(int j = 0; j<callings.length; j++){
            int k = rank.get(callings[j]); // 현재 불린 선수의 현재 등수
            String p = players[k-1];
            players[k] = p;
            players[k-1] = callings[j];
            rank.put(callings[j],k-1); // 불린 선수의 현재 등수를 -1
            rank.put(p,k);    // 원래 앞 선 선수의 등수를 +1
        }
        return players;
    }
}
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String,Integer> rank = new HashMap<>();

        for(int i =0; i<players.length; i++){
            rank.put(players[i], i);
        }

        for(String calling : callings){
            int k = rank.get(calling);
            String player = players[k-1];
            players[k-1] = calling;
            players[k] = player;
            rank.put(player, k);
            rank.put(calling, k-1);
        }
        return players;
    }
}
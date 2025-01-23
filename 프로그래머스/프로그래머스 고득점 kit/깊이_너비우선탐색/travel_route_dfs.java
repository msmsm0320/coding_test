import java.util.*;

class Solution {
    int length = 0;
    boolean[] visited;
    ArrayList<String> list;

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        length = tickets.length;

        visited = new boolean[length];
        list = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(list);
        answer = list.get(0).split(" ");

        return answer;
    }
    public void dfs(String begin, String route, String[][] tickets, int depth){
        if (depth==length){
            list.add(route);
            return;
        }
        for (int i = 0; i<length; i++){
            if(!visited[i] && begin.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth+1);
                visited[i] = false;
            }
        }
    }
}
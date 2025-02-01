import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {

        int answer =0;
        List<List<Integer>> graph = new ArrayList<>();
        boolean visited[] = new boolean[n+1];

        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        for(int i = 1; i<=n; i++){
            Collections.sort(graph.get(i));
        }

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int que_size, node;

        while(!queue.isEmpty()){
            que_size = queue.size();
            for(int i = 0; i<que_size; i++){
                node = queue.poll();
                for(int j = 0; j<graph.get(node).size(); j++){
                    if(visited[graph.get(node).get(j)] == false){
                        visited[graph.get(node).get(j)] =true;
                        queue.offer(graph.get(node).get(j));
                    }
                }
            }
            answer= que_size;
        }
        return answer;
    }
}
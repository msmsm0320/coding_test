import java.util.*;

class Solution {
    static boolean[] visited;

    static List<List<Integer>> graph;

    public int bfs(int n, int[][] edge, int start){
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            // 노드 레벨 처리
            count = q.size();

            for(int i =0; i<count; i++){
                int point = q.poll();
                for(int j = 0; j<graph.get(point).size(); j++){
                    if(visited[graph.get(point).get(j)]) continue;
                    visited[graph.get(point).get(j)] = true;
                    q.offer(graph.get(point).get(j));
                }
            }
        }
        return count;
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 방문 여부 확인
        visited = new boolean[n+1];

        Arrays.sort(edge,(a,b) ->Integer.compare(a[0],b[0]));

        //양방향 그래프 생성
        graph = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int j = 0; j<edge.length; j++){
            graph.get(edge[j][0]).add(edge[j][1]);
            graph.get(edge[j][1]).add(edge[j][0]);
        }

        answer =bfs(n,edge,1);
        return answer;
    }
}
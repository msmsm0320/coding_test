import java.util.*;

class Solution {
    static int arr[][];

    public int bfs(int n, int start){
        int visited[] = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        int count = 1;
        q.offer(start);

        while(!q.isEmpty()){
            int point = q.poll();
            visited[point] =1;

            for(int i = 1; i<=n; i++){

                if(visited[i] == 1) continue;
                if(arr[point][i] == 1){
                    count++;
                    q.offer(i);
                }
            }
        }

        return Math.abs(n-count - count);

    }


    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n+1][n+1];


        for(int i = 0; i<wires.length; i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        for(int i = 0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            arr[a][b] = 0;
            arr[b][a] = 0;

            answer = Math.min(answer, bfs(n,a));

            arr[a][b] = 1;
            arr[b][a] = 1;
        }


        return answer;
    }
}
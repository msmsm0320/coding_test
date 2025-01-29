import java.util.*;

class Solution {

    static int path[];
    // 두 다리가 연결되지 않은 경우 연결
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) path[b] = a;

    }
    // 다리의 연결 정보 확인
    public int find(int k){
        if(path[k] == k) return k;
        else{
            return path[k] = find(path[k]);
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        path = new int[n];
        // 최소 비용 보장을 위한 정렬
        Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);
        // 다리 연결 정보 초기화
        for(int i = 0; i<n; i++){
            path[i] = i;
        }
        // 다리를 모두 연결
        for(int i=0 ; i<costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0],costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
}
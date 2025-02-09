import java.util.*;


public class BOJ_15649_N과_M_1 {

    static int arr[];
    static boolean visited[];

    // dfs 접근
    public static void dfs(int depth, int m){
        if(depth == m){
            for(int k : arr){
                System.out.print(k + " ");
            }
            System.out.println();
            return;
        }
        // 반복문을 통해 조합 변경
        for(int i = 1; i<visited.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            dfs(depth+1, m);
            visited[i] = false;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int m = scanner.nextInt();

        visited = new boolean[N+1];
        arr = new int[m];

        dfs(0, m);

    }
}

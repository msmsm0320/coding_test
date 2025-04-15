import java.io.*;
import java.util.StringTokenizer;

public class 알고리즘_수업_병합_정렬_1_review {

    public static int A[];
    static int tmp[];
    public static int count = 0;
    public static int end = 0;
    public static int result = -1;

    public static void merge_sort(int p, int r){
        if (p < r){
            int q = (p + r) /2;
            merge_sort(p,q);
            merge_sort(q+1,r);
            merge(p,q,r);
        }
    }

    public static void merge(int p, int q, int r){
        int i = p;
        int j = q+1;
        int t = p;



        while(i <= q && j <= r){
            if (A[i] <= A[j]){
                tmp[t++] = A[i++];
            } else{
                tmp[t++] = A[j++];
            }
        }

        while( i <= q){
            tmp[t++] = A[i++];
        }

        while(j<=r){
            tmp[t++] = A[j++];
        }

        for(int idx = p; idx <= r; idx++){
            A[idx] = tmp[idx];
            count++;
            if (count == end){
                result = A[idx];
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A = new int[N];
        tmp = new int[N];

        int K = Integer.parseInt(st.nextToken());

        end = K;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0,N-1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();


    }

}

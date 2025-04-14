import java.io.*;
import java.util.*;

public class 알고리즘_수업_병합_정렬_1 {
    static int[] A, tmp;
    static int N, K, count = 0, result = -1;

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        int i = start, j = mid + 1, t = start;

        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = A[i++];
        }

        while (j <= end) {
            tmp[t++] = A[j++];
        }

        for (int idx = start; idx <= end; idx++) {
            A[idx] = tmp[idx];
            count++;
            if (count == K) {
                result = A[idx];
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);
        System.out.println(result);
    }
}

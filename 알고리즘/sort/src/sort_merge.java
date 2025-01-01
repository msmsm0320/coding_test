public class sort_merge {

    private static int[] sorted; // 임시 배열

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        // 두 부분 리스트를 병합
        while (l <= mid && r <= right) {
            if (a[l] <= a[r]) { // 왼쪽 부분리스트의 원소가 작거나 같은 경우
                sorted[idx] = a[l];
                idx++;
                l++;
            } else { // 오른쪽 부분리스트의 원소가 작은 경우
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        // 왼쪽 부분리스트 남은 데이터 처리
        while (l <= mid) {
            sorted[idx] = a[l];
            idx++;
            l++;
        }

        // 오른쪽 부분리스트 남은 데이터 처리
        while (r <= right) {
            sorted[idx] = a[r];
            idx++;
            r++;
        }

        // 정렬된 데이터를 원래 배열에 복사
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return; // 원소가 1개인 경우
        }

        int mid = (left + right) / 2; // 중간 지점 계산
        mergeSort(a, left, mid); // 왼쪽 부분 정렬
        mergeSort(a, mid + 1, right); // 오른쪽 부분 정렬
        merge(a, left, mid, right); // 두 부분 병합
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 2};
        sorted = new int[arr.length]; // 정렬을 위한 임시 배열 생성

        System.out.println("Before sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(arr, 0, arr.length - 1); // 병합 정렬 수행

        System.out.println("After sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

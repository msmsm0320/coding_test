public class sort_quick_mid {

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void quick_sort_mid(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return; // 정렬할 원소가 1개 이하인 경우, return
        }

        int pivot = partition(a, lo, hi);

        quick_sort_mid(a, lo, pivot); // 왼쪽 부분 정렬
        quick_sort_mid(a, pivot + 1, hi); // 오른쪽 부분 정렬
    }

    private static int partition(int[] a, int left, int right) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2]; // 중간 피벗 선택

        while (true) {
            do {
                lo++;
            } while (a[lo] < pivot);

            do {
                hi--;
            } while (a[hi] > pivot && lo <= hi);

            if (lo >= hi) {
                return hi; // 피벗의 최종 위치 반환
            }
            swap(a, lo, hi); // 교환
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 7, 1, 3, 2};

        System.out.println("Before sorting: ");
        printArray(arr);

        quick_sort_mid(arr, 0, arr.length - 1);

        System.out.println("After sorting: ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

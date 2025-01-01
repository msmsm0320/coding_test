public class sort_quick_left {

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void quick_sort_left(int[] a, int lo, int hi){
        if(lo >= hi){
            return;
        }

        int pivot = partition(a, lo, hi);
        quick_sort_left(a, lo, pivot -1);
        quick_sort_left(a, pivot+1, hi);
    }

    private static int partition(int[] a, int left, int right){

        int lo = left;
        int hi = right;
        int pivot = a[left];

        while(lo <hi){
            while(a[hi] > pivot && lo < hi){
                hi--;
            }

            while(a[lo] <= pivot && lo < hi){ // 같은 경우 신경 쓰기
                lo++;
            }

            swap(a, lo, hi);
        }
        swap(a, left, lo);
        return lo;
    }
    public static void main(String[] args) {
        int arr[] = {4, 7, 1, 3, 2};

        System.out.println("Before sorting: ");
        printArray(arr);

        quick_sort_left(arr, 0, arr.length - 1);

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

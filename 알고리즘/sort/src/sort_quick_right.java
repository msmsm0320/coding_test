public class sort_quick_right {

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void quick_sort_right(int[] a, int lo, int hi){
        if(lo >= hi){
            return;
        }

        int pivot = partition(a, lo, hi);
        quick_sort_right(a, lo, pivot -1);
        quick_sort_right(a, pivot+1, hi);
    }

    private static int partition(int a[], int left, int right){
        int lo = left;
        int hi = right;
        int pivot = a[right];

        while(lo < hi){

            while(a[lo] < pivot && lo < hi){
                lo++;
            }

            while(a[hi] >= pivot && lo < hi){ // 같은 경우 신경 쓰기
                hi--;
            }

            swap(a,lo,hi);
        }
        swap(a,right,hi);

        return hi;
    }
    public static void main(String[] args) {
        int arr[] = {4, 7, 1, 3, 2};

        System.out.println("Before sorting: ");
        printArray(arr);

        quick_sort_right(arr, 0, arr.length - 1);

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

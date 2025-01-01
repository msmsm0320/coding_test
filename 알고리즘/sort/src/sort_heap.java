import java.util.PriorityQueue;

public class sort_heap {
    public static void main(String[] args) {

        int[] arr = {3, 7, 5, 4, 2, 8};
        System.out.println(" 정렬 전 original 배열 : ");
        for(int val : arr){
            System.out.print(val + " ");
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i =0; i < arr.length; i++){
            heap.add(arr[i]);
        }

        for(int i =0; i <arr.length; i++){
            arr[i] = heap.poll();
        }

        System.out.println("\n 정렬 후 배열 : ");
        for(int val : arr) {
            System.out.print(val + " ");
        }
    }
}

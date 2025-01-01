import java.util.Arrays;

public class sort_selection {

    public static void swap(int arr[],int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {4,7,1,3,2};

        for(int i = 0; i<arr.length-1; i++){
            int minindex = i;
            for (int j = i+1; j<arr.length; j++){
                if(arr[j] < arr[minindex]) minindex = j;
            }
            swap(arr,i,minindex);
        }
        System.out.println(Arrays.toString(arr));
    }
}

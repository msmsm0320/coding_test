import java.util.Arrays;

public class sort_Insertion {

    public static void main(String[] args) {
        int key,j;
        int arr[] = {4,7,1,3,2};

        for(int i = 1;i<arr.length;i++){
            key = arr[i];
            j = i-1;
            while(j>=0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}

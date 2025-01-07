import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int l = 0;
        int i,j,k;

        for(int a[] : commands){
            i = a[0]-1;
            j = a[1];
            k = a[2]-1;
            int temp[] = Arrays.copyOfRange(array,i,j);
            Arrays.sort(temp);
            answer[l++] = temp[k];
        }
        return answer;
    }
}
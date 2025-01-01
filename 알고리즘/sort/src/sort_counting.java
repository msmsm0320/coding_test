public class sort_counting {
    public static void main(String[] args) {

        int[] array = new int[100];
        int[] counting = new int[31];
        int[] result = new int[100];

        for(int i=0; i < array.length; i++) {
            array[i] = (int)(Math.random()*31);
        }

        for(int i = 0; i<array.length;i++){
            counting[array[i]]++;
        }

        for(int i = 1; i<counting.length; i++){
            counting[i] += counting[i-1];
        }

        for(int i=array.length - 1; i>=0; i--){ // i 번째 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤, counting 배열의 값을 인덱스로 사용하여 result에 value 값 저장
            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        // 초기 배열
        System.out.println("array[]");
        for(int i = 0; i < array.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n\n");


        // Counting 배열
        System.out.println("counting[]");
        for(int i = 0; i < counting.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.print(counting[i] + "\t");
        }
        System.out.println("\n\n");


        // 정렬된 배열
        System.out.println("result[]");
        for(int i = 0; i < result.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.print(result[i] + "\t");
        }
        System.out.println();
    }
}

import java.util.Arrays;
import java.util.Deque;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {

    private void resize(){ // 스택에서 배열의 크기를 동적으로 관리하기 위해 사용

        if(Arrays.equals(array, EMPTY_ARRAY)){ // 배열이 비어있다면 새로운 배열 생성
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        int arrayCapacity = array.length;

        if(size == arrayCapacity){ // 배열이 가득 찼다면 size를 2배
            int newSize = arrayCapacity * 2;

            array = Arrays.copyOf(array, newSize);
            return;
        }

        if(size < (arrayCapacity / 2)){ // 배열의 현재 크기가 최대의 절반보다 작을 경우 size를 1/2배
            int newCapacity = (arrayCapacity / 2);

            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }
    }
    @Override
    public E push(E item) {
        if (size == array.length){
            resize();
        }
        array[size] = item;
        size++;

        return item;
    }

    @Override
    public E pop() {

        if(size == 0){ // stack이 비어있을 경우 예외 발생
            throw new EmptyStackException();
        }

        E obj = (E) array[size - 1]; // 삭제될 요소를 반환하기 위한 임시 변수

        array[size - 1] = null; // 요소 삭제

        size--; // size 1 감소
        resize();

        return obj; // 요소 반환
    }

    @Override
    public E peek() {
        if (size == 0) throw new EmptyStackException();

        return (E) array[size -1];
    }


    @Override
    public int search(Object value) { // 찾으려는 데이터가 상단의 데이터로부터 얼마만큼 떨어져 있는지에 대한 상대적 위치 값(Top으로부터 떨어져 있는 거리, 단, 1부터 시작)
        if(value == null){// null을 찾는 경우
            for(int idx = size - 1; idx >= 0; idx--){
                if(array[idx] == null){
                    return size - idx;
                }
            }
        }else{
            for(int idx = size - 1; idx >= 0; idx--){ // 원하는 값을 찾는 경우
                if(array[idx].equals(value)){
                    return size -idx;
                }
            }
        }
        return -1; // 찾지 못 한 경우에는 -1을 return 한다.
    }

    @Override
    public int size() { // size 크기 반환
        return size;
    }

    @Override
    public void clear() { // 모든 요소들을 null 처리
        for(int i = 0; i< size; i++){
            array[i] = null;
        }
        size = 0;
        resize();
    }

    @Override
    public boolean empty() { // stack이 비어있는지 true/false 반환
        return size == 0;
    }

    private static final int DEFAULT_CAPACITY = 10; // 최초 할당 크기
    private static final Object[] EMPTY_ARRAY = {}; // 아무것도 없는 빈 배열

    private Object[] array; // 요소를 담을 배열
    private int size; // 요소 개수

    public Stack(){
        this.array = EMPTY_ARRAY;
        this.size =0;
    }

    public Stack(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }
}

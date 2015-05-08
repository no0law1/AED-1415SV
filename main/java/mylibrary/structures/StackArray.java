package mylibrary.structures;

/**
 *
 */
public class StackArray<E> implements Stack<E> {

    public static final int DEFAULT_SIZE = 32;

    private int size;
    private E[] stack;

    public StackArray(){
        this(DEFAULT_SIZE);
    }

    public StackArray(int size){
        stack = (E[]) new Object[size];
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E push(E item) {
        if(!isFull()){
            stack[size++] = item;
            return item;
        }
        throw new IllegalStateException();
    }

    @Override
    public E pop() {
        if(!isEmpty()){
            E aux = stack[--size];
            stack[size] = null;
            return aux;
        }
        throw new IllegalStateException();
    }

    @Override
    public E peek() {
        if(!isEmpty()) {
            return stack[size];
        }
        throw new IllegalStateException();
    }

    public boolean isFull(){
        return size >= stack.length;
    }
}

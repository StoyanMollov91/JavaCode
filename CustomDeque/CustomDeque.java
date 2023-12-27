import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomDeque<T> {
    private static final int INITIAL_CAPACITY = 4;
    private int size;
    private int capacity;
    private T[] data;
    public CustomDeque(){
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
        this.data = (T[]) new Object[this.capacity];
    }
    public int size(){
        return this.size;
    }
    private void resize(){
        this.capacity *= 2;
        T[] copy = (T[]) new Object[this.capacity];
        System.arraycopy(this.data, 0, copy, 0, this.size);
        this.data = copy;
    }
    private void shrink(){
        this.capacity /= 2;
        T[] copy = (T[]) new Object[this.capacity];
        System.arraycopy(this.data, 0, copy, 0, this.size);
        this.data = copy;
    }
    public T peek(){
        if (this.isEmpty()){
            throw new NoSuchElementException("The deque is empty.");
        }
        return this.data[size - 1];
    }
    public void push(T element){
        if (this.size == this.capacity){
            this.resize();
        }
        this.data[size++] = element;
    }
    public T pop(){
        if (this.isEmpty()){
            throw new NoSuchElementException("The deque is empty.");
        }
        if (this.size <= this.capacity / 4){
            this.shrink();
        }
        T last = this.data[size - 1];
        this.data[size - 1] = null;
        this.size--;
        return last;
    }
    public T poll(){
        return this.pop();
    }
    public void offer(T element){
        if (this.size == this.capacity){
            this.resize();
        }
        System.arraycopy(this.data, 0, this.data, 1, this.size);
        this.data[0] = element;
        this.size++;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public boolean contains(T element){
        for (int i = 0; i < this.size; i++){
            if (this.data[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    public void forEach(Consumer<T> consumer){
        for (int i = 0; i < this.size; i++){
            consumer.accept(this.data[i]);
        }
    }
}

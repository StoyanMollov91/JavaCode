import java.util.function.Consumer;

public class CustomList<T> {
    private static final int INITIAL_CAPACITY = 4;
    private int size;
    private int capacity;
    private T[] data;
    public CustomList(){
         this.data = (T[]) new Object[INITIAL_CAPACITY];
         this.capacity = INITIAL_CAPACITY;
         this.size = 0;
    }
    private void resize(){
        this.capacity *= 2;
        T[] copy = (T[]) new Object[this.capacity];
        System.arraycopy(this.data, 0, copy, 0, this.size);
        this.data = copy;
    }
    public void add(T element){
        if (this.size == this.capacity){
            this.resize();
        }
        this.data[this.size++] = element;
    }
    public T get(int index){
        this.checkIndex(index);
        return this.data[index];
    }
    private void checkIndex(int index){
        if (index < 0 || index >= this.size){
            String message = String.format("Index %d out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }
    public T remove(int index){
        T element = this.get(index);
        this.shiftLeft(index);
        this.size--;
        if (this.size <= this.capacity / 4){
            this.shrink();
        }
        return element;
    }
    private void shiftLeft(int index){
        System.arraycopy(this.data, index + 1, this.data, index, this.size - 1 - index);
        this.data[size - 1] = null;
    }
    private void shrink(){
        this.capacity /= 2;
        T[] copy = (T[]) new Object[this.capacity];
        System.arraycopy(this.data, 0, copy, 0, this.size);
        this.data = copy;
    }
    public void add(int index, T element){
        this.checkIndex(index);
        if (this.size == this.capacity){
            this.resize();
        }
        this.shiftRight(index);
        this.data[index] = element;
        this.size++;

    }
    private void shiftRight(int index){
        System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
    }
    public boolean contains(T element){
        for (int i = 0; i < this.size; i++){
            if (this.get(i).equals(element)){
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
    public int size(){
        return this.size;
    }

}

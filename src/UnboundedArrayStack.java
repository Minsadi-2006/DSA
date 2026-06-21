package hackerRank;

public class UnboundedArrayStack<T> {

    private Object[] array;
    private int size;

    private static final int INITIAL_CAPACITY = 4;

    public UnboundedArrayStack() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(T item) {

        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty - cannot pop");
        }

        size--;
        T item = (T) array[size];
        array[size] = null; // help garbage collection

        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }

        return item;
    }


    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty - cannot peek");
        }
        return (T) array[size - 1];
    }


    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }


    public static void main(String[] args) {
        UnboundedArrayStack<Integer> stack = new UnboundedArrayStack<>();

        System.out.println("Start capacity: " + stack.capacity());

        for (int i = 1; i <= 10; i++) {
            stack.push(i);
            System.out.println("Pushed " + i + " | size=" + stack.size()
                    + " | capacity=" + stack.capacity());
        }

        System.out.println("\nNow popping...");
        while (!stack.isEmpty()) {
            int val = stack.pop();
            System.out.println("Popped " + val + " | size=" + stack.size()
                    + " | capacity=" + stack.capacity());
        }
    }
}
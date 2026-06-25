public class ArrayCircularQueue {

    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full! Cannot enqueue " + value);
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
        System.out.println("Enqueued: " + value);
    }


    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty! Cannot dequeue.");
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + value);
        return value;
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty! Cannot peek.");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }


    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
        System.out.println("  front index=" + front + "  rear index=" + rear + "  size=" + size);
    }


    public static void main(String[] args) {
        System.out.println("=== ArrayCircularQueue ===\n");
        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        System.out.println("Queue full? " + queue.isFull());

        queue.dequeue();
        queue.dequeue();
        queue.display();


        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("Queue empty? " + queue.isEmpty());
    }
}

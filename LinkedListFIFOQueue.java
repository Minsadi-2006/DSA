public class LinkedListFIFOQueue {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;  
    private Node rear;   
    private int size;    
    public LinkedListFIFOQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);  

        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;   
            rear = newNode;      

        size++;
        System.out.println("Enqueued: " + value);
    }
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Underflow! Queue is empty.");

        int value = front.data;    
        front = front.next;        

        if (front == null) {
            rear = null;
        }

        size--;
        System.out.println("Dequeued: " + value);
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty. Nothing to peek.");
        System.out.println("Front element: " + front.data);
        return front.data;
    }

    public int peekRear() {
        if (isEmpty()) throw new RuntimeException("Queue is empty. Nothing to peek.");
        System.out.println("Rear element: " + rear.data);
        return rear.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
    public void display() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }

        System.out.print("Queue [FRONT → REAR]: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" → ");
            current = current.next; 
        }
        System.out.println("  (size=" + size + ")");
    }
    public static void main(String[] args) {
        System.out.println("=== LinkedListFIFOQueue ===\n");
        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();

    
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();

        System.out.println();

        queue.peek();
        queue.peekRear();

        System.out.println();

        queue.dequeue();
        queue.dequeue();
        queue.display();

        System.out.println();

        queue.enqueue(50);
        queue.enqueue(60);
        queue.display();

        System.out.println();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("Queue empty? " + queue.isEmpty());

     
        try {
            queue.dequeue();
        } catch (RuntimeException e) {
            System.out.println("Caught error: " + e.getMessage());
        }
    }
}

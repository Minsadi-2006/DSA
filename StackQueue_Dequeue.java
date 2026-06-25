import java.util.Stack;

public class StackQueue_Dequeue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public StackQueue_Dequeue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }


    public void enqueue(int value) {

        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }

        inStack.push(value);

        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        System.out.println("Enqueued: " + value);
    }


    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty! Cannot dequeue.");
        }
        int value = outStack.pop();
        System.out.println("Dequeued: " + value);
        return value;
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty! Cannot peek.");
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    public int size() {
        return outStack.size() + inStack.size();
    }

    public void display() {
        System.out.print("Queue (front -> rear): ");

        Stack<Integer> temp = new Stack<>();
        temp.addAll(outStack);
        while (!temp.isEmpty()) {
            System.out.print(temp.pop() + " ");
        }

        Stack<Integer> tempIn = new Stack<>();
        tempIn.addAll(inStack);
        Object[] inArr = inStack.toArray();
        for (Object o : inArr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("=== StackQueue - Dequeue Friendly ===\n");
        StackQueue_Dequeue queue = new StackQueue_Dequeue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        queue.dequeue();
        queue.dequeue();

        System.out.println("After 2 dequeues, front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        queue.enqueue(50);
        System.out.println("After enqueue(50), size: " + queue.size());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("Queue empty? " + queue.isEmpty());
    }
}

package hackerRank;

import java.util.Stack;


public class StackQueueEnqueueFriendly<T> {

    private Stack<T> inStack = new Stack<>();
    private Stack<T> outStack = new Stack<>();


    public void enqueue(T item) {
        inStack.push(item);
    }


    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty - cannot dequeue");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }



    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public int size() {
        return inStack.size() + outStack.size();
    }


    public static void main(String[] args) {
        StackQueueEnqueueFriendly<Integer> queue = new StackQueueEnqueueFriendly<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);


        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Is empty? " + queue.isEmpty());
    }
}
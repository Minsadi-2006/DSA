package hackerRank;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly<T> {

    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();


    public void push(T item) {
        q2.add(item);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty - cannot pop");
        }
        return q1.remove();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }


    public static void main(String[] args) {
        QueueStackPopFriendly<Integer> stack = new QueueStackPopFriendly<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}
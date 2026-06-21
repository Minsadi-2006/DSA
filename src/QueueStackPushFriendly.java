package hackerRank;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly<T> {
    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();


    public void push(T item) {
        q1.add(item);
    }


    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty - cannot pop");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        T topItem = q1.remove();
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;

        return topItem;
    }


    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }


    public static void main(String[] args) {
        QueueStackPushFriendly<Integer> stack = new QueueStackPushFriendly<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);


        System.out.println("Pop: "    + stack.pop());
        System.out.println("Pop: "    + stack.pop());
        System.out.println("Pop: "    + stack.pop());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}

public class LinkedListStack {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null; 
        }
    }

    private Node top;    
    private int size; 

    public LinkedListStack() {
        top = null;
        size = 0;
    }
    public void push(int value) {
        Node newNode = new Node(value);   
        newNode.next = top;               
        top = newNode;                    
        size++;
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow! Stack is empty.");

        int value = top.data;   
        top = top.next;         
        size--;
        System.out.println("Popped: " + value);
        return value;
    }
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty. Nothing to peek.");
        System.out.println("Top element: " + top.data);
        return top.data;
    }


    public boolean isEmpty() {
        return top == null;
    }
    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) { System.out.println("Stack is empty."); return; }

        System.out.print("Stack (TOP → BOTTOM): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" → ");
            current = current.next;    
        }
        System.out.println("  (size=" + size + ")");
    }
    public static void main(String[] args) {
        System.out.println("=== LinkedListStack ===\n");
        LinkedListStack stack = new LinkedListStack();

      
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();

        System.out.println();

       
        stack.peek();

        System.out.println();

       
        stack.pop();
        stack.pop();
        stack.display();

        System.out.println();

        stack.push(50);
        stack.display();

        System.out.println();

       
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Stack empty? " + stack.isEmpty());

      
        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println("Caught error: " + e.getMessage());
        }
    }
}

public class CircularDoublyLinkedList {

    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;  
    private int size;   

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    public void insertAtHead(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;    
            newNode.next = head;      
            newNode.prev = tail;      
            head.prev = newNode;     
            tail.next = newNode; 
            head = newNode;        
        }

        size++;
        System.out.println("Inserted at head: " + value);
    }

    public void insertAtTail(int value) {
        if (head == null) {
            insertAtHead(value);
            return;
        }

        Node tail = head.prev;
        Node newNode = new Node(value);

        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;

        size++;
        System.out.println("Inserted at tail: " + value);
    }

    public void insertAt(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) { 
            insertAtHead(value); 
            return; 
        }
        if (index == size) { 
            insertAtTail(value); 
            return; 
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node prevNode = current.prev;
        Node newNode = new Node(value);

        newNode.next = current;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        current.prev = newNode;

        size++;
        System.out.println("Inserted " + value + " at index " + index);
    }

    public int deleteAtHead() {
        if (isEmpty()) throw new RuntimeException("List is empty!");

        int value = head.data;

        if (size == 1) {
            head = null;
        } else {
            Node tail = head.prev;
            Node newHead = head.next;

            tail.next = newHead;
            newHead.prev = tail;
            head = newHead;
        }

        size--;
        System.out.println("Deleted from head: " + value);
        return value;
    }

    public int deleteAtTail() {
        if (isEmpty()) throw new RuntimeException("List is empty!");

        Node tail = head.prev;
        int value = tail.data;

        if (size == 1) {
            head = null;
        } else {
            Node newTail = tail.prev;
            newTail.next = head;
            head.prev = newTail;
        }

        size--;
        System.out.println("Deleted from tail: " + value);
        return value;
    }

    public int deleteAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        if (index == 0) return deleteAtHead();
        if (index == size - 1) return deleteAtTail();

        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;

        int value = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
        System.out.println("Deleted at index " + index + ": " + value);
        return value;
    }

    public int search(int value) {
        if (isEmpty()) { 
            System.out.println("List is empty."); 
            return -1; 
        }

        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == value) {
                System.out.println("Found " + value + " at index " + i);
                return i;
            }
            current = current.next;
        }
        System.out.println(value + " not found.");
        return -1;
    }

    public boolean isEmpty() { return head == null; }
    public int size()        { return size; }

    public void display() {
        if (isEmpty()) { 
            System.out.println("List is empty."); 
            return; 
        }
        System.out.print("Forward  (HEAD→): ");
        Node current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.data);
            if (i < size - 1) System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println("  [wraps back to HEAD=" + head.data + "]  size=" + size);
    }

    public void displayReverse() {
        if (isEmpty()) { 
            System.out.println("List is empty."); 
            return; 
        }
        System.out.print("Backward (TAIL→): ");
        Node current = head.prev;
        for (int i = 0; i < size; i++) {
            System.out.print(current.data);
            if (i < size - 1) System.out.print(" <-> ");
            current = current.prev;
        }
        System.out.println("  [wraps back to TAIL=" + head.prev.data + "]");
    }

    public static void main(String[] args) {
        System.out.println("=== CircularDoublyLinkedList ===\n");
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtHead(5);
        list.insertAt(2, 15);
        list.display();
        list.displayReverse();

        System.out.println();
        list.search(15);
        list.search(99);

        System.out.println();
        list.deleteAtHead();
        list.deleteAtTail();
        list.deleteAt(1);
        list.display();
        list.displayReverse();

        System.out.println("\nSize: " + list.size());
    }
}
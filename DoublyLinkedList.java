
public class DoublyLinkedList {


    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    public void insertAtHead(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Inserted at head: " + value);
    }


    public void insertAtTail(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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
        Node newNode = new Node(value);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node prevNode = current.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = current;
        current.prev = newNode;
        size++;
        System.out.println("Inserted " + value + " at index " + index);
    }


    public int deleteAtHead() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Cannot delete.");
        }
        int value = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        System.out.println("Deleted from head: " + value);
        return value;
    }


    public int deleteAtTail() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Cannot delete.");
        }
        int value = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        System.out.println("Deleted from tail: " + value);
        return value;
    }


    public int deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) return deleteAtHead();
        if (index == size - 1) return deleteAtTail();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        int value = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        System.out.println("Deleted at index " + index + ": " + value);
        return value;
    }


    public int search(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Found " + value + " at index " + index);
                return index;
            }
            current = current.next;
            index++;
        }
        System.out.println(value + " not found in list.");
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    // Display forward (head to tail)
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Forward:  NULL <- ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println(" -> NULL  (size=" + size + ")");
    }


    public void displayReverse() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Backward: NULL <- ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) System.out.print(" <-> ");
            current = current.prev;
        }
        System.out.println(" -> NULL");
    }


    public static void main(String[] args) {
        System.out.println("=== DoublyLinkedList ===\n");
        DoublyLinkedList list = new DoublyLinkedList();

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

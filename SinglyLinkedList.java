
public class SinglyLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }


    public void insertAtHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Inserted at head: " + value);
    }


    public void insertAtTail(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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
        Node newNode = new Node(value);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Inserted " + value + " at index " + index);
    }


    public int deleteAtHead() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Cannot delete.");
        }
        int value = head.data;
        head = head.next;
        size--;
        System.out.println("Deleted from head: " + value);
        return value;
    }


    public int deleteAtTail() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Cannot delete.");
        }
        int value;
        if (head.next == null) {
            value = head.data;
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            value = current.next.data;
            current.next = null;
        }
        size--;
        System.out.println("Deleted from tail: " + value);
        return value;
    }


    public int deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            return deleteAtHead();
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        int value = current.next.data;
        current.next = current.next.next;
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


    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List: HEAD -> ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println(" -> NULL  (size=" + size + ")");
    }


    public static void main(String[] args) {
        System.out.println("=== SinglyLinkedList ===\n");
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtHead(5);
        list.insertAt(2, 15);
        list.display();

        list.search(15);
        list.search(99);

        list.deleteAtHead();
        list.deleteAtTail();
        list.deleteAt(1);
        list.display();

        System.out.println("Size: " + list.size());
    }
}

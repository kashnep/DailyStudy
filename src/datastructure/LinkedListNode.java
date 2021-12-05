package datastructure;

class LinkedList {
    Node header;

    static class Node<T> {
        T data;
        Node<T> next = null;
    }

    LinkedList() {
        header = new Node();
    }

    public void append(Object d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(Object d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }
}

public class LinkedListNode {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append("kashnep");
        ll.append(4);
        ll.delete(1);
        ll.append(455);
        ll.retrieve();
    }
}
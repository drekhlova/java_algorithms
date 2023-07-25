//Связный список

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node prev;
        Node next;

        Node (int i) {
            data = i;
            prev = null;
            next = null;
        }
    }

    // Метод разворота двусвязного списка
    void reverse() {
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // Вывод списка
    void printList (Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main (String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.prev = list.head;
        list.head.next.next = new Node(3);
        list.head.next.next.prev = list.head.next;
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.prev = list.head.next.next;

        System.out.println("Первоначальный связный список:");
        list.printList(list.head);

        list.reverse();
        System.out.println(" ");
        System.out.println("Перевернутый связный список:");
        list.printList(list.head);
    }
}
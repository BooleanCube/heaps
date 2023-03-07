package structures;


public class SortedLinkedList implements PQueue {

    private Node<Integer> head;

    @Override
    public void insert(Integer value) {
        Node<Integer> newNode = new Node<>(value);
        if (head == null || value.compareTo(head.value) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<Integer> current = head;
            while (current.next != null && value.compareTo(current.next.value) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    @Override
    public Integer popHead() {
        if (head == null) {
            return null;
        }
        Node<Integer> returnNode = head;
        head = head.next;
        return returnNode.value;
    }

    @Override
    public Integer peekHead() {
        return head.value;
    }

    @Override
    public void printList() {
        Node<Integer> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    private static class Node<T extends Comparable<T>> {
        Integer value;
        Node<T> next;

        Node(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

}
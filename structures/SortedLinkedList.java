package structures;

/**
 * SortedLinkedList is a priority queue implementation using a singly linked list.
 * This implementation maintains a sorted list, where elements are added in their sorted position
 * with respect to other elements already in the list. This allows for constant-time access to the
 * minimum element.
 */
public class SortedLinkedList implements PQueue {

    /**
     * The head node of the linked list.
     */
    private Node<Integer> head;

    /**
     * Insert a new element in its sorted position in the list.
     * Time complexity: O(n)
     *
     * @param value the element to insert
     */
    @Override
    public void insert(Integer value) {
        Node<Integer> newNode = new Node<>(value);
        if(head == null) {
            head = newNode;
        }
        else if(value.compareTo(head.value) < 0) {
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

    /**
     * Remove and return the minimum element from the list.
     * Time complexity: O(1)
     *
     * @return the minimum element in the list
     */
    @Override
    public Integer popHead() {
        if (head == null) {
            return null;
        }
        Node<Integer> returnNode = head;
        head = head.next;
        return returnNode.value;
    }

    /**
     * Return the minimum element in the list without removing it.
     * Time complexity: O(1)
     *
     * @return the minimum element in the list
     */
    @Override
    public Integer peekHead() {
        return head.value;
    }

    /**
     * Print the contents of the list in square brackets.
     * Time complexity: O(n)
     */
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

    /**
     * Clear the SortedLinkedList values entirely.
     * Time complexity: O(1)
     */
    @Override
    public void clear() {
        head = null;
    }

    /**
     * A node of the linked list that stores an element of type Integer.
     * @param <T> the type of the element stored in the node (must be comparable)
     */
    private static class Node<T extends Comparable<T>> {
        Integer value;
        Node<T> next;

        /**
         * Create a new node with the given element.
         *
         * @param value the element to store in the node
         */
        Node(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

}

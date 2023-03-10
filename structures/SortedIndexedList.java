package structures;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class implements a priority queue using a sorted indexed list data structure.
 */
public class SortedIndexedList implements PQueue {

    /**
     * A list to hold the elements in the priority queue.
     */
    private final ArrayList<Integer> indexedList;

    /**
     * Constructor for SortedIndexedList.
     * Initializes the indexedList.
     */
    public SortedIndexedList() {
        this.indexedList = new ArrayList<>();
    }

    /**
     * Inserts an element into the priority queue.
     * Time complexity: O(log(n))
     *
     * @param value The element to be inserted.
     */
    @Override
    public void insert(Integer value) {
        int index = Collections.binarySearch(this.indexedList, value, Collections.reverseOrder());

        if (index < 0) {
            index = -(index + 1);
        }

        this.indexedList.add(index, value);
    }

    /**
     * Removes and returns the head element of the priority queue.
     * Time complexity: O(1)
     *
     * @return The head element of the priority queue, or null if the queue is empty.
     */
    @Override
    public Integer popHead() {
        if(this.indexedList.isEmpty()) {
            return null;
        }

        return this.indexedList.remove(this.indexedList.size()-1);
    }

    /**
     * Returns the head element of the priority queue without removing it.
     * Time complexity: O(1)
     *
     * @return The head element of the priority queue, or null if the queue is empty.
     */
    @Override
    public Integer peekHead() {
        return this.indexedList.get(this.indexedList.size()-1);
    }

    /**
     * Clears the SortedIndexedList values entirely.
     * Time complexity: O(1)
     */
    @Override
    public void clear() {
        indexedList.clear();
    }

    /**
     * Prints the elements in the priority queue.
     */
    @Override
    public void printList() {
        System.out.println(this.indexedList);
    }

}

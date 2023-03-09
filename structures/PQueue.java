package structures;

/**
 * The PQueue interface provides the methods to implement a priority queue data structure.
 */
public interface PQueue {

    /**
     * Inserts the specified integer value into the priority queue.
     * @param value the integer value to be inserted into the priority queue
     */
    public void insert(Integer value);

    /**
     * Removes and returns the head element of the priority queue.
     * @return the head element of the priority queue
     */
    public Integer popHead();

    /**
     * Returns the head element of the priority queue without removing it.
     * @return the head element of the priority queue
     */
    public Integer peekHead();

    /**
     * Clears the Priority Queue data structure and resets all values.
     * This operation can't be undone!
     */
    public void clear();

    /**
     * Prints the elements of the priority queue in a list format.
     */
    public void printList();

}

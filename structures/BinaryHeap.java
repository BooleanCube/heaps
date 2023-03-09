package structures;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A BinaryHeap implementation of the PQueue interface for priority queue functionality.
 */
public class BinaryHeap implements PQueue {

    /**
     * The underlying heap data structure is an ArrayList of Integers.
     */
    private final ArrayList<Integer> heap;

    /**
     * Creates a new BinaryHeap object with an empty ArrayList and a dummy node for 1-indexing.
     */
    public BinaryHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(-1); // dummy node for 1-indexed heap list
    }

    /**
     * Swaps the elements at the given indices in the heap ArrayList.
     *
     * @param idx1 the index of the first element to swap
     * @param idx2 the index of the second element to swap
     */
    private void swap(int idx1, int idx2) {
        Collections.swap(this.heap, idx1, idx2);
    }

    /**
     * Inserts a new element into the binary heap by adding it to the end of the ArrayList
     * and then sifting it up the tree until it is in its correct position.
     * Time complexity: O(log(n))
     *
     * @param value the value to insert into the heap
     */
    @Override
    public void insert(Integer value) {
        int index = this.heap.size();
        this.heap.add(value);

        while(index > 1) {
            if(this.heap.get(index >> 1) > this.heap.get(index)) {
                swap(index, index >> 1);
            }
            else {
                break;
            }
            index >>= 1;
        }
    }

    /**
     * Removes and returns the head element of the binary heap by swapping it with the last
     * element in the ArrayList and then sifting that element down the tree until it is in
     * its correct position.
     * Time complexity: O(log(n))
     *
     * @return the head element of the heap
     */
    @Override
    public Integer popHead() {
        if(this.heap.size() <= 1) return null;

        swap(1, this.heap.size()-1);
        int minValue = this.heap.remove(this.heap.size()-1);

        int index = 1;
        while(true) {
            int minChoice = Integer.MAX_VALUE;
            boolean first = true;
            if(this.heap.size() > index*2 && this.heap.get(index*2) < this.heap.get(index)) {
                minChoice = Math.min(this.heap.get(index*2), minChoice);
            }
            if(this.heap.size() > index*2+1 && this.heap.get(index*2+1) < this.heap.get(index) && this.heap.get(index*2+1) < minChoice) {
                minChoice = this.heap.get(index*2+1);
                first = false;
            }
            if(minChoice == Integer.MAX_VALUE) {
                break;
            }
            else if(first) {
                swap(index, index*2);
                index *= 2;
            }
            else {
                swap(index, index*2+1);
                index = index*2+1;
            }
        }

        return minValue;
    }

    /**
     * Returns the head element of the binary heap without removing it.
     * Time complexity: O(1)
     *
     * @return the head element of the heap
     */
    @Override
    public Integer peekHead() {
        return this.heap.get(1);
    }

    /**
     * Clears the BinaryHeap values entirely.
     * Time complexity: O(1)
     */
    @Override
    public void clear() {
        this.heap.clear();
        this.heap.add(-1);
    }

    /**
     * Prints the contents of the binary heap as a list.
     */
    @Override
    public void printList() {
        System.out.println(this.heap);
    }

}
